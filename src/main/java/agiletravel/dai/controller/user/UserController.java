package agiletravel.dai.controller.user;

import agiletravel.dai.entity.User;
import agiletravel.dai.reconst.success.UserSuccess;
import agiletravel.dai.service.user.UserService;
import agiletravel.dai.utils.Response;
import agiletravel.dai.utils.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/register")
    public Response userRegister(@RequestBody User user){
        userService.userRegister(user);
        return ResponseFactory.okResponse(UserSuccess.RESIGTER_SUCCESS);
    }

    @RequestMapping("/user/infoUpdate")
    public Response userInfoUpdate(@RequestBody User user){
        userService.userInfoUpdate(user);
        return ResponseFactory.okResponse(UserSuccess.UPDATE_INFO_SUCCESS);
    }

    @RequestMapping("/user/login")
    public Response userLogin(@RequestBody User user){
        userService.userLogin(user);
        return ResponseFactory.okResponse(UserSuccess.LOGIN_SUCCESS);
    }
}
