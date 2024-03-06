package jm.task.core.jdbc;


import static jm.task.core.jdbc.service.UserServiceImpl.userDao;

public class Main {
    public static void main(String[] args) {

       //   userDao.createUsersTable();
        userDao.saveUser("Alex", "Ivanov", (byte) 23);
     //   userDao.saveUser("Anton", "Petrov", (byte) 35);
      //  userDao.saveUser("Elena", "Gromova", (byte) 35);
      //  userDao.saveUser("Sergey", "Kim", (byte) 42);
      //  System.out.println(userDao.getAllUsers().toString());
      //  userDao.removeUserById(2);

       // userDao.dropUsersTable();
    }

}
