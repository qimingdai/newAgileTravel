package agiletravel.dai.dao.notice;

import agiletravel.dai.entity.Notice;
import agiletravel.dai.form.reNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("NoticeDao")
public class NoticeDaoImpl  implements  NoticeDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<reNotice> findByTravelid(String travelid) {
        String sql="select noticeid, users.openId, nickname, content, noticeTime from notice,users where notice.openid=users.openid and travelid=?";
        List<reNotice> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(reNotice.class),travelid);
        return list;
    }

    @Override
    public void InsertNotice(Notice notice) {
        String sql="insert into notice (travelid,openid,content) values (?,?,?)";
        jdbcTemplate.update(sql,notice.getTravelId(),notice.getOpenId(),notice.getContent());

    }

    @Override
    public void deleteNotice(String noticeId) {
        String sql="delete from notice where noticeid=?";
        jdbcTemplate.update(sql,noticeId);
    }
}
