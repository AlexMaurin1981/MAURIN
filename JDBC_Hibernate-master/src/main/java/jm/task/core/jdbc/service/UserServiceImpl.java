package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {


   public  UserDao userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {

        userDaoHibernate.createUsersTable();
        System.out.println("Таблица создана");

    }

    public void dropUsersTable() {

        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {

        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("имя пользователя - " + name + " добавлено в базу");
    }

    public void removeUserById(long id) {

        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {

        System.out.println(userDaoHibernate.getAllUsers().toString());
        return userDaoHibernate.getAllUsers();
    }

    public void cleanUsersTable() {

        userDaoHibernate.cleanUsersTable();
        System.out.println("Таблица очищена");
    }
}
