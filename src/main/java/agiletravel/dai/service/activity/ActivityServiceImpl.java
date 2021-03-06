package agiletravel.dai.service.activity;

import agiletravel.dai.MyException.ActivityException;
import agiletravel.dai.dao.activity.ActivityDao;
import agiletravel.dai.dao.attendList.AttendListDao;
import agiletravel.dai.dao.user.UserDao;
import agiletravel.dai.entity.Activity;
import agiletravel.dai.entity.AttendList;
import agiletravel.dai.entity.User;
import agiletravel.dai.form.reDetailActivity;
import agiletravel.dai.form.reSimpleActivity;
import agiletravel.dai.form.reViewUser;
import agiletravel.dai.reconst.activityEnum;
import agiletravel.dai.utils.*;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * CacheConfig表示数据缓存会被储存到名为activity的缓存对象中
 * CachePut一般用于数据库的增加和修改操作，key="#p0.travelid"，表示使用bean的第一个参数travelid作为key值
 * Cacheable一般用于数据库的查询，会优先查询redis，没有的话再去mysql中查找，并set到redis中
 * CacheEvict一般用于数据库的删除操作，数据库删除后会同步到redis中delete掉那个键值对
 */

@Service("activityService")
@Slf4j
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private AttendListDao attendListDao;

    @Autowired
    private JavaRedis javaRedis;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void releaseActivityInfo(Activity activity) {
        String context = activity.getDescription();
        //判断是否包含敏感词汇
        if(SensetiveUtils.isContaintBadWord(context,1)){
            throw new ActivityException(activityEnum.INCLUDE_BAD_WORDS);
        }
        activityDao.addActivity(activity);
        log.info("添加活动的剩余人数缓存");
        javaRedis.setKeyValue(activity.getTravelId(),String.valueOf(activity.getMaxNumber()));
        log.info("添加剩余人数缓存成功");
    }

    @Override
    @Transactional
    public void updateActivityInfo(Activity activity) {
        String context = activity.getDescription();
        if(SensetiveUtils.isContaintBadWord(context,1)){
            throw new ActivityException(activityEnum.INCLUDE_BAD_WORDS);
        }
        activityDao.updateActivity(activity);
        List<reViewUser> list = attendListDao.findByTravelid(activity.getTravelId());
        log.info("开始通知参加的人活动变更，需要通知"+list.size()+"人");
        for(reViewUser users : list){
            String activityTime = new SimpleDateFormat("YYYY-MM-dd hh:mm").format(activity.getStartTime());
            alertActivity(users.openId,activity.getTitle(),activity.getPlace(),activityTime,
                    MiniProgramConst.updateTemplate_id,MiniProgramConst.updateForm_id);
            log.info("通知活动变更中......");
        }
        log.info("通知所有参加活动的人活动更新完毕");
    }

    @Override
    @Transactional
    public void cancleActivity(String travelid) {
        activityDao.cancleActivity(travelid);
        List<reViewUser> list = attendListDao.findByTravelid(travelid);
        Activity activity = activityDao.findByTravelId(travelid);
        log.info("开始通知所有人活动取消，需要通知"+list.size()+"人");
        for(reViewUser users: list){
            alertActivity(users.openId,activity.getTitle(),activity.getPlace(),"",
                    MiniProgramConst.cancleTemplate_id,MiniProgramConst.cancleForm_id);
            attendListDao.deleteAttendList(travelid, users.openId);
            log.info("取消参加活动中......");
        }
        log.info("通知所有人活动取消完毕");
        log.info("清除取消的活动的剩余人数缓存");
        if(javaRedis.deleteKey(travelid)){
            log.info("清除缓存成功");
        }else{
            log.info("清除缓存失败");
        }


    }

    @Override
    public List<Activity> viewAll() {
        List list =  activityDao.findAll();
        if(list==null || list.isEmpty()){
            throw new ActivityException(activityEnum.NO_ACTIVITY);
        }
        return list;
    }

    @Override
    public List<reSimpleActivity> findByKind(String kind) {

        List<reSimpleActivity> list = activityDao.findByKind(kind);
        if (list == null || list.isEmpty()) {
            throw new ActivityException(activityEnum.ACTIVITY_NOT_EXIST);
        }
        return list;
    }

    @Override
    public List<reSimpleActivity> findByCity(String city) {
        List<reSimpleActivity> list = activityDao.findByCity(city);
        if (list == null || list.isEmpty()) {
            throw new ActivityException(activityEnum.ACTIVITY_NOT_EXIST);
        }
        return list;
    }


    @Override
    public List<reSimpleActivity> findByTitle(String title) {
        List<reSimpleActivity> list = activityDao.findByTitle(title);
        if(list == null || list.isEmpty()){
            throw new ActivityException(activityEnum.ACTIVITY_NOT_EXIST);
        }
        return list;
    }

    @Override
    public Activity viewDetail(String travelid) {

         Activity activity = activityDao.findByTravelId(travelid);
         if(activity==null){
             throw new ActivityException(activityEnum.ACTIVITY_NOT_EXIST);
         }
//         String restNumber = javaRedis.getKeyValue(travelid);
//         Integer rest = Integer.parseInt(restNumber);
//         String startTime = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(activity.getStartTime());
//         String endTime = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(activity.getEndTime());
//         reDetailActivity reDetailActivity = new reDetailActivity(activity.getTravelId(),activity.getOpenId(),activity.getPlace(),startTime,endTime,
//                 activity.getTitle(),activity.getDescription(),activity.getTypes(),activity.getCost(),activity.getMaxNumber(),rest);
         return activity;
    }

    @Override
    public List<reSimpleActivity> viewMyReleaseActivities(String openid) {
        List<reSimpleActivity> list = activityDao.findByOpenId(openid);
        if(list==null || list.isEmpty()){
            throw new ActivityException(activityEnum.NO_RELEASE_ACTIVITIES);
        }
        return list;
    }

    @Override
    public void alertActivity(String openid,String travelName, String travelPlace, String travelTime, String template_id, String form_id) {
        Gson gson = new Gson();
        String access_token = javaRedis.getKeyValue("access_token");
        System.out.println(access_token);
        if(access_token==null){
//            access_token=MiniProgramUtils.getAccessToken();
            access_token="test_access_token";
            javaRedis.setAccessTokenKey("access_token",access_token,MiniProgramConst.ACCESS_TOKEN_LAST_TIME);
        }
        MessageTemplate message = new MessageTemplate();
        message.setTouser(openid);
        message.setTemplate_id(template_id);
        message.setForm_id(form_id);
        message.setData(MessageTemplateUtils.setMessageData(travelName,travelPlace,travelTime));
        String jsonObject = gson.toJson(message);
        String errcode = MiniProgramUtils.sendTemplateMessage(access_token,jsonObject);
        if("0".equals(errcode)){
            log.info("系统消息提示成功");
        }else {
            log.info("系统消息提示失败");
        }

    }


}
