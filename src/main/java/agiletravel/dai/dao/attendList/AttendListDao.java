package agiletravel.dai.dao.attendList;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.entity.AttendList;
import agiletravel.dai.entity.User;
import agiletravel.dai.form.reViewHistory;
import agiletravel.dai.form.reViewUser;

import java.util.List;

public interface AttendListDao {
    void addAttendList(String travelid, String openid);
    void deleteAttendList(String travelid, String openid);
    List<reViewHistory> findByOpenid(String openid);
    List<reViewUser> findByTravelid(String travelid);
    void updateComment(String comment, String travelid,String openid);
    AttendList findByBothId(String travelid,String openid);
}
