package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;



public class Main {
    public static void main(String[] args) {
        UserDao userDaoHibernate = new UserDaoHibernateImpl();
       userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Alex", "Ivanov", (byte) 23);
        userDaoHibernate.saveUser("Anton", "Petrov", (byte) 35);
        userDaoHibernate.saveUser("Elena", "Gromova", (byte) 35);
        userDaoHibernate.saveUser("Sergey", "Kim", (byte) 42);
        System.out.println(userDaoHibernate.getAllUsers().toString());
        userDaoHibernate.removeUserById(2);
        userDaoHibernate.dropUsersTable();
    }

}
