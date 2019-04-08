package agiletravel.dai.service.user;

import agiletravel.dai.entity.User;

public interface UserService {
    //用户注册，即添加用户
    void userRegister(User user);

    //用户增添/修改个人信息
    void userInfoUpdate(String openid, String nickName, String phone);

    //获取信息
    User findUser(String openid);
}
