package agiletravel.dai.service.attendList;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.entity.AttendList;
import agiletravel.dai.entity.User;
import agiletravel.dai.form.reViewHistory;
import agiletravel.dai.form.reViewUser;

import java.util.List;

public interface AttendListService {
    /**
     * 加入出游活动
     * @param attendList
     */
    void attendActivity(AttendList attendList);

    /**
     * 退出参加的出游活动
     * @param attendList
     */
    void quitActivity(AttendList attendList);

    /**
     * 查看“我”参加过的出游活动
     * @param openid
     * @return
     */
    List<reViewHistory> attendHistory(String openid);

    /**
     * 评价某次出游活动
     * @param attendList
     */
    void commentActivity(AttendList attendList);

    /**
     * 查看加入出游的人
     * @param travelid
     * @return
     */
    List<reViewUser> listAttendUsers(String travelid);
}
