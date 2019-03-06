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
        userDao.addUser(user);
    }

    @Override
    public void userLogin(User user) {
        User userFind = userDao.findById(user.getOpenid());
        if(userFind == null){
            throw new UserException(userEnum.User_NUMBER_DO_NOT_EXSIT);
        }
        /*
        用户登录功能还是不能够理解，用户是否可以退出登录
        * */
    }

    @Override
    public void userInfoUpdate(User user) {
        userDao.updateUser(user);
    }
}
