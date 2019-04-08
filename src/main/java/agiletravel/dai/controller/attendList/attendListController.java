package agiletravel.dai.controller.attendList;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.entity.AttendList;
import agiletravel.dai.entity.User;
import agiletravel.dai.form.reViewHistory;
import agiletravel.dai.form.reViewUser;
import agiletravel.dai.reconst.success.AttendListSuccess;
import agiletravel.dai.service.attendList.AttendListService;
import agiletravel.dai.utils.Response;
import agiletravel.dai.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class attendListController {
    @Autowired
    private AttendListService attendListService;

    @RequestMapping("/attendList/attend")
    public Response attendActivity(@RequestBody AttendList attendList){
        attendListService.attendActivity(attendList);
        return ResponseFactory.okResponse(AttendListSuccess.ATTEND_ACTIVITY_SUCCESS);
    }

    @RequestMapping("/attendList/quit")
    public Response quitActivity(@RequestBody AttendList attendList){
        attendListService.quitActivity(attendList);
        return ResponseFactory.okResponse(AttendListSuccess.QUIT_ACTIVITY_SUCCESS);
    }

    @RequestMapping("/attendList/history")
    public Response attendHistory(@RequestBody AttendList  attendList){
        List<reViewHistory> list = attendListService.attendHistory(attendList.getOpenId());
        return ResponseFactory.okResponse(list);
    }

    @RequestMapping("/attendList/comment")
    public Response commentActivity(@RequestBody AttendList attendList){
        attendListService.commentActivity(attendList);
        return ResponseFactory.okResponse(AttendListSuccess.COMMENT_ACTIVITY_SUCCESS);
    }

    @RequestMapping(value = "/attendList/viewAttenders",method = RequestMethod.GET)
    public Response viewAttendUsers(@RequestParam String travelId){
        List<reViewUser> list = attendListService.listAttendUsers(travelId);
        return ResponseFactory.okResponse(list);
    }

    @RequestMapping("/attendList/isAttend")
    public Response isAttend(@RequestBody AttendList attendList){
        boolean result = attendListService.isAttend(attendList.getTravelId(),attendList.getOpenId());
        return ResponseFactory.okResponse(result);
    }

}
