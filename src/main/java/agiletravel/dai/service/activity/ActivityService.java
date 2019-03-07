package agiletravel.dai.service.activity;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.form.reDetailActivity;
import agiletravel.dai.form.reSimpleActivity;

import java.util.Date;
import java.util.List;

public interface ActivityService {
    /**
     * 发布出游活动
     * @param activity
     */
    void releaseActivityInfo(Activity activity);

    /**
     * 更新出游活动的信息
     * @param activity
     */
    void updateActivityInfo(Activity activity);

    /**
     * 取消出游活动
     * @param travelid
     */
    void cancleActivity(String travelid);

    /**
     * 查看所有有效期内的活动
     * @return
     */
    List<reSimpleActivity> viewAll();
    //按活动类别查看

    /**
     *按照活动类别查看出游活动
     * @param kind
     * @return
     */
    List<reSimpleActivity> findByKind(String kind);

    /**
     * 按照活动地点查看出游活动
     * @param city
     * @return
     */
    List<reSimpleActivity> findByCity(String city);
    //按时间区间查看
    List<Activity> findBetweenTime(Date startTime, Date endTime);

    /**
     * 查看活动详情
     * @param travelid
     * @return
     */
    reDetailActivity viewDetail(String travelid);

    /**
     * 查看“我”发布的所有活动
     * @param openid
     * @return
     */
    List<reSimpleActivity> viewMyReleaseActivities(String openid);

    /**
     * 活动信息提醒
     * @param openid 参加者的id
     * @param travelName    活动名称
     * @param travelPlace   活动地点
     * @param travelTime    活动事件
     * @param template_id   消息模板的id
     * @param form_id       表单按钮的id
     */
    void alertActivity(String openid,String travelName, String travelPlace, String travelTime, String template_id, String form_id);


}
