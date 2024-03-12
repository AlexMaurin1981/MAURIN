package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDao userDao = new  UserDaoHibernateImpl();
      List<User> userList = new ArrayList<>();


        User user1 = new User("Alex", "Ivanov", (byte) 23);
        User user2 = new User("Anton", "Petrov", (byte) 35);
        User user3 = new User("Elena", "Gromova", (byte) 35);
        User user4 = new User("Sergey", "Kim", (byte) 42);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userDao.createUsersTable();

        for (User r: userList ) {
          userDao.saveUser(r.getName(), r.getLastName(), r.getAge());
          System.out.println("пользователь c именем "+ r.getName() + " добавлен в таблицу");
        }
       userDao.removeUserById(2);
       System.out.println("пользователь уделен");
       userDao.cleanUsersTable();
        System.out.println("таблица очищена");
        userDao.dropUsersTable();
        System.out.println("таблица удалена");





    }

}
