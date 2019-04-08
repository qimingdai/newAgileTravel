package agiletravel.dai.controller.user;

import agiletravel.dai.entity.User;
import agiletravel.dai.reconst.success.UserSuccess;
import agiletravel.dai.service.user.UserService;
import agiletravel.dai.utils.Response;
import agiletravel.dai.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/register")
    public Response userRegister(@RequestBody User user){
        userService.userRegister(user);
        return ResponseFactory.okResponse(UserSuccess.RESIGTER_SUCCESS);
    }

    @RequestMapping(value = "/user/infoUpdate",method = RequestMethod.POST)
    public Response userInfoUpdate(@RequestBody User user){
        userService.userInfoUpdate(user.getOpenId(),user.getNickname(),user.getPhoneNumber());
        return ResponseFactory.okResponse(UserSuccess.UPDATE_INFO_SUCCESS);
    }

    @RequestMapping(value = "/user/info",method = RequestMethod.GET)
    public Response findUserInfo(@RequestParam String openId){
        User user = userService.findUser(openId);
        return ResponseFactory.okResponse(user);
    }

}
