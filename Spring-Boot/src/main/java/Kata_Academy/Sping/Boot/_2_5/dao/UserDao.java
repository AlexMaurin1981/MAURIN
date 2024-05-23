package Kata_Academy.Sping.Boot._2_5.dao;



import Kata_Academy.Sping.Boot._2_5.model.User;

import java.util.List;

public interface UserDao {
   List<User> getAllUsers();

   void saveUser(User user);

   User getUser(int id);

   void updateUser(User user);

   void deleteUser(int id);
}
