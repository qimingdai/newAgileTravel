package agiletravel.dai.dao.activity;

import agiletravel.dai.entity.Activity;

import java.util.List;

public interface ActivityDao {
    void addActivity(Activity activity);
    void updateActivity(Activity activity);
    void cancleActivity(String travelid);
    List<Activity> findAll();
    List<Activity> findByKind(String kind);
    List<Activity> findByCity(String city);
    List<Activity> findByOpenId(String openid);
    Activity findByTravelId(String travelid);
}
