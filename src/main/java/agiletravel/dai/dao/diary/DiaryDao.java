package agiletravel.dai.dao.diary;

import agiletravel.dai.entity.Diary;
import agiletravel.dai.form.reDiary;

import java.util.List;

public interface DiaryDao {
    void insertDiary(Diary diary);
    void deleteDiary(String diaryid);
    Diary selectDiaryByDiaryId(String diaryid);
    List<Diary> selectDiaryByOpenId(String openId);
    int viewDiary(String diaryid);
    int likeDiary(String diaryid);
}
