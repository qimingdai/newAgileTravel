package agiletravel.dai.dao.user;

import agiletravel.dai.entity.User;

public interface UserDao {
    User findById(String openid);
    void addUser(User user);
    void updateUser(String openid, String nickName, String phone);

}
