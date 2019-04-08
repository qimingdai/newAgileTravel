package agiletravel.dai.service.user;

import agiletravel.dai.MyException.UserException;
import agiletravel.dai.dao.user.UserDao;
import agiletravel.dai.entity.User;
import agiletravel.dai.reconst.userEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void userRegister(User user) {
        System.out.println(user);
        userDao.addUser(user);
    }


    @Override
    public User findUser(String openid) {
        User user =  userDao.findById(openid);
        if(user==null){
            throw new UserException(userEnum.User_NUMBER_DO_NOT_EXSIT);
        }
        return user;
    }

    @Override
    public void userInfoUpdate(String openid, String nickName, String phone) {

        userDao.updateUser(openid,nickName,phone);
    }
}
