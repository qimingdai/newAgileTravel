package agiletravel.dai.service.activity;

import agiletravel.dai.entity.Activity;

import java.util.Date;
import java.util.List;

public interface ActivityService {
    //发布活动
    void releaseActivityInfo(Activity activity);
    //修改出游信息
    void updateActivityInfo(Activity activity);
    //取消出游
    void cancleActivity(String travelid);
    //查看所有活动列表
    List<Activity> viewAll();
    //按活动类别查看

    /**
     *
     * @param kind
     * @return
     */
    List<Activity> findByKind(String kind);
    //按活动地点查看
    List<Activity> findByCity(String city);
    //按时间区间查看
    List<Activity> findBetweenTime(Date startTime, Date endTime);
    //查看活动详情
    Activity viewDetail(String travelid);

    //查看我发布的活动
    List<Activity> viewMyReleaseActivities(String openid);
    //活动信息提醒
    void alertActivity(String openid,String travelName, String travelPlace, String travelTime, String template_id, String form_id);


}
