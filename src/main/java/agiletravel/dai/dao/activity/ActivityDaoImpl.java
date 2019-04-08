package agiletravel.dai.dao.activity;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.form.reDetailActivity;
import agiletravel.dai.form.reSimpleActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Repository("activityDao")
public class ActivityDaoImpl implements ActivityDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addActivity(Activity activity) {
        String sql="insert into activity values(?,?,?,?,?,?,?,?,?,?,?)";
        activity.setTravelId(UUID.randomUUID().toString().replace("-",""));
        jdbcTemplate.update(sql,activity.getTravelId(),activity.getOpenId(),activity.getPlace(),
                activity.getStartTime(),activity.getEndTime(),activity.getTitle(),activity.getDescription(),
                activity.getFlag(),activity.getTypes(),activity.getCost(),activity.getMaxNumber());
    }

    @Override
    public void updateActivity(Activity activity) {
//        String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(activity.getStartTime());
//        String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(activity.getEndTime());
        String sql="update activity set place=?, startTime=?, endTime=?, title=?, description=?, " +
                "types=?, cost=?, maxNumber=? where travelid=?";
        jdbcTemplate.update(sql,activity.getPlace(),activity.getStartTime(),activity.getEndTime(),
                activity.getTitle(), activity.getDescription(),activity.getTypes(),
                activity.getCost(),activity.getMaxNumber(), activity.getTravelId());
    }

    @Override
    public void cancleActivity(String travelid) {
        String sql="update activity set flag=0 where travelid=?";
        jdbcTemplate.update(sql,travelid);
    }

    @Override
    public List<Activity> findAll() {
        String sql="select * from activity where flag=1";
        List<Activity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Activity.class));
        return list;
    }

    @Override
    public List<reSimpleActivity> findByKind(String kind) {
        String sql="select travelid,openid,title,description,cost from activity where kind =? and flag=1";
        List<reSimpleActivity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reSimpleActivity.class),kind);
        return list;
    }

    @Override
    public List<reSimpleActivity> findByCity(String city) {
        String sql="select travelid,openid,title,description,cost from activity where city=? and flag=1";
        List<reSimpleActivity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reSimpleActivity.class),city);
        return list;
    }

    @Override
    public List<reSimpleActivity> findByOpenId(String openid) {
        String sql = "select travelid,openid,title,description,cost from activity where openid=? ";
        List<reSimpleActivity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reSimpleActivity.class),openid);
        return list;
    }

    @Override
    public List<reSimpleActivity> findByTitle(String title) {
        String sql="select travelid,openid,title,description,cost from activity where flag=1 and title like '%"+title+"%' ";
        List<reSimpleActivity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reSimpleActivity.class));
        return list;
    }

    @Override
    public Activity findByTravelId(String travelid) {
        String sql="select * from activity where travelid=?";
        List<Activity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Activity.class),travelid);
        return list.isEmpty()?null:list.get(0);
    }
}
