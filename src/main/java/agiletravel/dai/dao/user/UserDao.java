package agiletravel.dai.dao.user;

import agiletravel.dai.entity.User;

public interface UserDao {
    User findById(String openid);
    void addUser(User user);
    void updateUser(User user);

}
