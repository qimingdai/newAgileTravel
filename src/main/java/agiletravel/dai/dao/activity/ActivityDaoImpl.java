package agiletravel.dai.dao.activity;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.form.reDetailActivity;
import agiletravel.dai.form.reSimpleActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.UUID;

@Repository("activityDao")
public class ActivityDaoImpl implements ActivityDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addActivity(Activity activity) {
        String sql="insert into activities values(?,?,?,?,?,?,?,?,?,?,?)";
        activity.setTravelid(UUID.randomUUID().toString().replace("-",""));
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
    public List<reSimpleActivity> findAll() {
        String sql="select travelid,travelName,description,cost from activities where flag=1";
        List<reSimpleActivity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reSimpleActivity.class));
        return list;
    }

    @Override
    public List<reSimpleActivity> findByKind(String kind) {
        String sql="select travelid,travelName,description,cost from activities where kind =? and flag=1";
        List<reSimpleActivity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reSimpleActivity.class),kind);
        return list;
    }

    @Override
    public List<reSimpleActivity> findByCity(String city) {
        String sql="select travelid,travelName,description,cost from activities where city=? and flag=1";
        List<reSimpleActivity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reSimpleActivity.class),city);
        return list;
    }

    @Override
    public List<reSimpleActivity> findByOpenId(String openid) {
        String sql = "select travelid,travelName,description,cost from activities where openid=? ";
        List<reSimpleActivity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reSimpleActivity.class),openid);
        return list;
    }

    @Override
    public Activity findByTravelId(String travelid) {
        String sql="select * from activities where travelid=?";
        List<Activity> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Activity.class),travelid);
        return list.isEmpty()?null:list.get(0);
    }
}
