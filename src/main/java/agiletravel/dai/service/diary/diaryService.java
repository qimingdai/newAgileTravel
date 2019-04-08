package agiletravel.dai.service.diary;

import agiletravel.dai.entity.Diary;
import agiletravel.dai.form.reDiary;

import java.util.List;

public interface diaryService {
    void releaseDiary(Diary diary);
    void deleteDiary(String diaryId);
    Diary viewDiaryDetail(String diaryId);
    List<Diary> viewMyDiary(String openId);
    Integer numberOfViews(String diaryId);
    Integer numberOfLikes(String diaryId);

}
