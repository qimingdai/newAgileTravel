package agiletravel.dai.dao.share;

import agiletravel.dai.entity.Shares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("shareDao")
public class ShareDaoImpl implements ShareDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void addShare(Shares shares) {
        String sql = "insert into shares values(?,?,?)";
        jdbcTemplate.update(sql,shares.getOpenid(),shares.getComment(),
                shares.getPicture1());
    }



    @Override
    public void viewCommentHistory(String openid) {
        String sql = "select * from shares where openid=?";

    }
}
