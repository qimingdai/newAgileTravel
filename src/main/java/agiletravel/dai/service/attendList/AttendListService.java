package agiletravel.dai.service.attendList;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.entity.AttendList;
import agiletravel.dai.entity.User;
import agiletravel.dai.form.reViewHistory;
import agiletravel.dai.form.reViewUser;

import java.util.List;

public interface AttendListService {
    //加入出游
    void attendActivity(AttendList attendList);
    //退出出游
    void quitActivity(AttendList attendList);
    //查看出游记录，即我曾经参加的活动
    List<reViewHistory> attendHistory(String openid);
    //评价出游活动
    void commentActivity(AttendList attendList);

    /**
     * 查看加入出游的人
     * @param travelid
     * @return
     */
    List<reViewUser> listAttendUsers(String travelid);
}
