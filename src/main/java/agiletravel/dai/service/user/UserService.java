package agiletravel.dai.service.user;

import agiletravel.dai.entity.User;

public interface UserService {
    //用户注册，即添加用户
    void userRegister(User user);
    //用户登录
    void userLogin(User user);
    //用户增添/修改个人信息
    void userInfoUpdate(User user);
}
