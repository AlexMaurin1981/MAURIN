package jm.task.core.jdbc.service;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService  {

    public  static UserDao userDao = new UserDaoJDBCImpl();

    public void createUsersTable() {

        userDao.createUsersTable();

        System.out.println("Таблица создана");



    }

    public void dropUsersTable() {

        userDao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {

        userDao.saveUser(name,lastName,age);



        System.out.println("имя пользователя - " + name + " добавлено в базу" );
    }

    public void removeUserById(long id) {

        userDao.removeUserById(id);

    }

    public List<User> getAllUsers() {
         System.out.println(userDao.getAllUsers().toString());
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {

        userDao.cleanUsersTable();

        System.out.println("Таблица очищена");
    }
}
