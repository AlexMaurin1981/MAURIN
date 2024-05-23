package Kata_Academy.Sping.Boot._2_5.service;


import Kata_Academy.Sping.Boot._2_5.dao.UserDao;
import Kata_Academy.Sping.Boot._2_5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {


    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();

    }


    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }


    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }


    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
