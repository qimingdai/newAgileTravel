package agiletravel.dai.service.attendList;

import agiletravel.dai.MyException.AttendListException;
import agiletravel.dai.dao.attendList.AttendListDao;
import agiletravel.dai.entity.Activity;
import agiletravel.dai.entity.AttendList;
import agiletravel.dai.entity.User;
import agiletravel.dai.form.reDetailActivity;
import agiletravel.dai.form.reViewHistory;
import agiletravel.dai.form.reViewUser;
import agiletravel.dai.reconst.activityEnum;
import agiletravel.dai.reconst.attendListEnum;
import agiletravel.dai.service.activity.ActivityService;
import agiletravel.dai.utils.JavaRedis;
import agiletravel.dai.utils.MiniProgramConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service("attendListService")
@Transactional
@Slf4j
public class AttendListServiceImpl implements AttendListService {
    @Autowired
    private AttendListDao attendListDao;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private JavaRedis javaRedis;

    @Override
    public boolean isAttend(String travelid, String openid) {
        if(attendListDao.findByBothId(travelid,openid)==null){
            return false;
        }
        return true;
    }

    @Override
    public void attendActivity(AttendList attendList) {
        //判断是否是重复参加
        if(isAttend(attendList.getTravelId(),attendList.getOpenId())){
            throw new AttendListException(attendListEnum.MULTIPLE_ATTENDS);
        }
        attendListDao.addAttendList(attendList.getTravelId(),attendList.getOpenId());
        //修改缓存中的剩余人数
        Integer restNumber = Integer.parseInt(javaRedis.getKeyValue(attendList.getTravelId()));
        if(restNumber<=0){
            throw new AttendListException(attendListEnum.FULL_PEOPLE_ERROR);
        }
        javaRedis.setKeyValue(attendList.getTravelId(),String.valueOf(--restNumber));

        Activity activity = activityService.viewDetail(attendList.getTravelId());
        String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(activity.getStartTime());
        log.info("开始给参加活动成功的人发送参加活动成功的通知");
        activityService.alertActivity(attendList.getOpenId(),activity.getTitle(),activity.getPlace(),
                startTime, MiniProgramConst.template_id,MiniProgramConst.form_id);
        log.info("给参加活动的人发送成功参加通知完毕");
    }

    @Override
    public void quitActivity(AttendList attendList) {
        attendListDao.deleteAttendList(attendList.getTravelId(),attendList.getOpenId());
        //增加缓存中的剩余人数
        Integer restNumber = Integer.parseInt(javaRedis.getKeyValue(attendList.getTravelId()));
        javaRedis.setKeyValue(attendList.getTravelId(),String.valueOf(++restNumber));
    }

    @Override
    public List<reViewHistory> attendHistory(String openid) {
        List<reViewHistory> list = attendListDao.findByOpenid(openid);
        if(list==null || list.isEmpty()){
            throw new AttendListException(attendListEnum.NO_ATTEND_ACTIVITY_HISTORY);
        }
        return list;
    }


    @Override
    public List<reViewUser> listAttendUsers(String travelid) {
        List<reViewUser> list = attendListDao.findByTravelid(travelid);
        if(list ==null || list.isEmpty()){
            throw new AttendListException(attendListEnum.NO_ATTENDERS_NOW);
        }
        return list;
    }

    @Override
    public void commentActivity(AttendList attendList) {

        attendListDao.updateComment(attendList.getComment(),attendList.getTravelId(),attendList.getOpenId());
    }
}
