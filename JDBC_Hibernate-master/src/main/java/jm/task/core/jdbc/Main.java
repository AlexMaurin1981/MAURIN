package jm.task.core.jdbc;



import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;


public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoJDBCImpl();
        userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("Alex", "Ivanov", (byte) 23);
        userDao.saveUser("Anton", "Petrov", (byte) 35);
        userDao.saveUser("Elena", "Gromova", (byte) 35);
        userDao.saveUser("Sergey", "Kim", (byte) 42);
            System.out.println(userDao.getAllUsers().toString());
        userDao.removeUserById(2);
        userDao.cleanUsersTable();
    }
}
