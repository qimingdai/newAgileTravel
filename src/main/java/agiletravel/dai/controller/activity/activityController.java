package agiletravel.dai.controller.activity;

import agiletravel.dai.entity.Activity;
import agiletravel.dai.form.reDetailActivity;
import agiletravel.dai.form.reSimpleActivity;
import agiletravel.dai.reconst.success.ActivitySuccess;
import agiletravel.dai.service.activity.ActivityService;
import agiletravel.dai.utils.Response;
import agiletravel.dai.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class activityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/activity/release")
    public Response releaseActivityInfo(@RequestBody Activity activity){
        activityService.releaseActivityInfo(activity);
        return ResponseFactory.okResponse(ActivitySuccess.RELEASE_ACTIVITY_SUCCESS);
    }

    @RequestMapping("/activity/update")
    public Response updateActivityInfo(@RequestBody Activity activity){
        activityService.updateActivityInfo(activity);
        return ResponseFactory.okResponse(ActivitySuccess.UPDATE_ACTIVITY_INFO_SUCCESS);
    }

    @RequestMapping(value = "/activity/cancel",method = RequestMethod.GET)
    public Response cancleActivity(@RequestParam String travelId){
        activityService.cancleActivity(travelId);
        return ResponseFactory.okResponse(ActivitySuccess.CANCLE_ACTIVITY_SUCCESS);
    }

    @RequestMapping(value="/activity/viewAll", method=RequestMethod.GET)
    public Response viewAll(){
        List<Activity> list = activityService.viewAll();
        return ResponseFactory.okResponse(list);
    }

    @RequestMapping("/activity/findByKind")
    public Response findByKind(@RequestParam String kind){
        List<reSimpleActivity> list = activityService.findByKind(kind);
        return ResponseFactory.okResponse(list);
    }

    @RequestMapping(value = "/activity/findByCity")
    public Response findByCity(@RequestParam String city){
        List<reSimpleActivity> list = activityService.findByCity(city);
        return ResponseFactory.okResponse(list);
    }

    @RequestMapping(value = "/activity/findByTitle", method = RequestMethod.GET)
    public Response findByTitle(@RequestParam String title){
        List<reSimpleActivity> list = activityService.findByTitle(title);
        return ResponseFactory.okResponse(list);
    }

    @RequestMapping(value = "/activity/detail", method = RequestMethod.GET)
    public Response findViewDetail(@RequestParam String travelId){
        Activity activityFind = activityService.viewDetail(travelId);
        return ResponseFactory.okResponse(activityFind);
    }

    @RequestMapping("/activity/myRelease")
    public Response viewMyReleaseActivities(@RequestParam String openid){
        List<reSimpleActivity> list = activityService.viewMyReleaseActivities(openid);
        return ResponseFactory.okResponse(list);
    }
}
