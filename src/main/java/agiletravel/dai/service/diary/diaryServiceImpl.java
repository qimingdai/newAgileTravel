package agiletravel.dai.service.diary;

import agiletravel.dai.MyException.DiaryException;
import agiletravel.dai.dao.diary.DiaryDao;
import agiletravel.dai.entity.Diary;
import agiletravel.dai.form.reDiary;
import agiletravel.dai.reconst.diaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("diaryService")
public class diaryServiceImpl implements diaryService {
    @Autowired
    private DiaryDao diaryDao;

    @Override
    public void releaseDiary(Diary diary) {
        diaryDao.insertDiary(diary);
    }

    @Override
    public void deleteDiary(String diaryId) {
        diaryDao.deleteDiary(diaryId);
    }

    @Override
    public Diary viewDiaryDetail(String diaryId) {
        Diary diary = diaryDao.selectDiaryByDiaryId(diaryId);
        if(diary==null){
            throw new DiaryException(diaryEnum.FOUND_NO_DIARY);
        }
        return diary;
    }

    @Override
    public List<Diary> viewMyDiary(String openId) {
        List<Diary> list = diaryDao.selectDiaryByOpenId(openId);
        if(list.isEmpty()){
            throw new DiaryException(diaryEnum.FOUND_NO_DIARY);
        }
        return list;
    }

    @Override
    public Integer numberOfViews(String diaryId) {
        return diaryDao.viewDiary(diaryId);
    }

    @Override
    public Integer numberOfLikes(String diaryId) {
        return diaryDao.likeDiary(diaryId);
    }
}
