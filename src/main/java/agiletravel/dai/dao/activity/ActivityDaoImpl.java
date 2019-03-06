package agiletravel.dai.dao.activity;

import agiletravel.dai.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@Repository("activityDao")
public class ActivityDaoImpl implements ActivityDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addActivity(Activity activity) {
        String sql="insert into activities values(?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,activity.getTravelid(),activity.getOpenid(),activity.getCity(),
                activity.getStartTime(),activity.getEndTime(),activity.getTravelName(),activity.getDescription(),
                activity.getFlag(),activity.getKind(),activity.getCost(),activity.getTotalNumber());
    }

    @Override
    public void updateActivity(Activity activity) {
        String sql="update activities set city=?, starttime=?, endtime=?, travelname=?, description=?, flag=?," +
                "kind=?, cost=?, totalnumber=? where travelid=?";
        jdbcTemplate.update(sql,activity.getCity(),activity.getStartTime(),activity.getEndTime(),
                activity.getTravelName(), activity.getDescription(),activity.getFlag(),activity.getKind(),
                activity.getCost(),activity.getTotalNumber(), activity.getTravelid());
    }

    @Override
    public void cancleActivity(String travelid) {
        String sql="update activities set flag=0 where travelid=?";
        jdbcTemplate.update(sql,travelid);
    }

    @Override
    public List<Activity> findAll() {
        String sql="select * from activities where flag=1";
        List<Activity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Activity>(Activity.class));
        return list;
    }

    @Override
    public List<Activity> findByKind(String kind) {
        String sql="select * from activities where kind =? and flag=1";
        List<Activity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Activity>(Activity.class),kind);
        return list;
    }

    @Override
    public List<Activity> findByCity(String city) {
        String sql="select * from activities where city=? and flag=1";
        List<Activity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Activity>(Activity.class),city);
        return list;
    }

    @Override
    public List<Activity> findByOpenId(String openid) {
        String sql = "select * from activities where openid=? ";
        List<Activity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Activity>(Activity.class),openid);
        return list;
    }

    @Override
    public Activity findByTravelId(String travelid) {
        String sql="select * from activities where travelid=?";
        List<Activity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Activity>(Activity.class),travelid);
        return list.isEmpty()?null:list.get(0);
    }
}
