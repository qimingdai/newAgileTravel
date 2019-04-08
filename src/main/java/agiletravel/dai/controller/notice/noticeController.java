package agiletravel.dai.controller.notice;

import agiletravel.dai.entity.Notice;
import agiletravel.dai.form.reNotice;
import agiletravel.dai.reconst.success.NoticeSuccess;
import agiletravel.dai.service.notice.NoticeService;
import agiletravel.dai.utils.Response;
import agiletravel.dai.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class noticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value="/notice/viewAll",method = RequestMethod.GET)
    public Response viewAllNotice(@RequestParam String travelId){
        List<reNotice> list = noticeService.viewNotice(travelId);
        return ResponseFactory.okResponse(list);
    }

    @RequestMapping("/notice/insertNotice")
    public Response insertNotice(@RequestBody Notice notice){
        noticeService.insertNotice(notice);
        return ResponseFactory.okResponse(NoticeSuccess.INSERT_NOTICE_SUCCESS);
    }

    @RequestMapping(value = "/notice/deleteNotice",method = RequestMethod.GET)
    public Response deleteNotice(String noticeid){
        noticeService.deleteNotice(noticeid);
        return ResponseFactory.okResponse(NoticeSuccess.DELETE_NOTICE_SUCCESS);
    }
}
