package agiletravel.dai.dao.diary;

import agiletravel.dai.entity.Diary;
import agiletravel.dai.form.reDiary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository("diaryDao")
public class DiaryDaoImpl implements DiaryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertDiary(Diary diary) {
        String sql="insert into diary (title,openid,content,pictureName,likes,views) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,diary.getTitle(),diary.getOpenId(),diary.getContent(),
                    diary.getPictureName(),diary.getLikes(),diary.getViews());
    }

    @Override
    public void deleteDiary(String diaryid) {
        String sql="delete from diary where diaryid=?";
        jdbcTemplate.update(sql,diaryid);

    }

    @Override
    public Diary selectDiaryByDiaryId(String diaryid) {
        String sql="select * from diary where diaryid=? ";
        List<Diary> list =  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Diary.class),diaryid);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public List<Diary> selectDiaryByOpenId(String openId) {
        String sql="select * from diary where openid=?";
        List<Diary> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Diary.class),openId);
        return list;
    }

    @Override
    public int viewDiary(String diaryid) {
        String sql="select views from diary where diaryid="+diaryid;
        Integer views= jdbcTemplate.queryForObject(sql,Integer.class);
        return views;
    }

    @Override
    public int likeDiary(String diaryid) {
        String sql="select likes from diary where diaryid="+diaryid;
        Integer likes = jdbcTemplate.queryForObject(sql,Integer.class);
        return likes;
    }
}
