package agiletravel.dai.dao.activity;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.form.reDetailActivity;
import agiletravel.dai.form.reSimpleActivity;

import java.util.List;

public interface ActivityDao {
    void addActivity(Activity activity);
    void updateActivity(Activity activity);
    void cancleActivity(String travelid);
    List<Activity> findAll();
    List<reSimpleActivity> findByKind(String kind);
    List<reSimpleActivity> findByCity(String city);
    List<reSimpleActivity> findByTitle(String title);
    List<reSimpleActivity> findByOpenId(String openid);
    Activity findByTravelId(String travelid);
}
