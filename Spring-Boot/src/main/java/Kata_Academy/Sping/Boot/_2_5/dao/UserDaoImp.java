package Kata_Academy.Sping.Boot._2_5.dao;

import Kata_Academy.Sping.Boot._2_5.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;



import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

@PersistenceContext
EntityManager entityManager;


   @Override
   public List<User> getAllUsers() {
       return  entityManager.createQuery("from User", User.class).getResultList();

   }

   @Override
   public void saveUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public User getUser(int id) {
       return entityManager.find(User.class,id);

   }

   @Override
   public void updateUser(User user) {
        entityManager.merge(user);
   }

   @Override
   public void deleteUser(int id) {
     User user = entityManager.find(User.class,id);
     if (user!=null){
        entityManager.remove(user);
     }
   }
}
