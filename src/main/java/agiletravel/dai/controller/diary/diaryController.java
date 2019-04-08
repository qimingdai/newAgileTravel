package agiletravel.dai.controller.diary;

import agiletravel.dai.entity.Diary;
import agiletravel.dai.form.reDiary;
import agiletravel.dai.reconst.success.DiarySuccess;
import agiletravel.dai.service.diary.diaryService;
import agiletravel.dai.utils.IOUtils;
import agiletravel.dai.utils.Response;
import agiletravel.dai.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
public class diaryController {
    @Autowired
    private diaryService diaryService;

    @RequestMapping(value = "/file/upload",method = RequestMethod.POST)
    public Response uploadImage(@RequestParam MultipartFile file){
        String url = IOUtils.uploadImage(file);
        System.out.println(url);
        return ResponseFactory.okResponse(url);
    }

    @RequestMapping("/diary/releaseDiary")
    public Response releaseDiary(@RequestBody Diary diary){
        diaryService.releaseDiary(diary);
        return ResponseFactory.okResponse(DiarySuccess.RELEASE_DIARY_SUCCESS);
    }

    @RequestMapping(value = "/diary/deleteDiary",method = RequestMethod.GET)
    public Response deleteResponse(@RequestParam String diaryId){
        diaryService.deleteDiary(diaryId);
        return ResponseFactory.okResponse(DiarySuccess.DELETE_DIARY_SUCCESS);
    }

    @RequestMapping(value = "/diary/diaryDetail",method = RequestMethod.GET)
    public Response viewDiaryDetail(@RequestParam String diaryId){
        Diary diary = diaryService.viewDiaryDetail(diaryId);
        return ResponseFactory.okResponse(diary);
    }

    @RequestMapping(value = "/diary/myDiary",method = RequestMethod.GET)
    public Response viewMyDiary(@RequestParam String openId){
        List<Diary> list = diaryService.viewMyDiary(openId);
        return ResponseFactory.okResponse(list);
    }
}
