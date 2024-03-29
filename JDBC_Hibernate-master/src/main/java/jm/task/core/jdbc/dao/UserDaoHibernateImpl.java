package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import java.util.List;



public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    SessionFactory sessionFactory =  Util.getSessionFactory();
    Transaction transaction = null;


    @Override
    public void createUsersTable() {


        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            String sql = ("CREATE TABLE IF NOT EXISTS users " +

                    "  ( id BIGINT NOT NULL AUTO_INCREMENT," +

                    "  name VARCHAR(50)," +

                    "  lastName VARCHAR(50)," +

                    "  age SMALLINT," +

                    "  PRIMARY KEY (id));");


            session.createNativeQuery(sql).executeUpdate();


            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }


        }
    }

    @Override
    public void dropUsersTable() {

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);


        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM User WHERE id = :id")
                    .setParameter("id", id).executeUpdate();

           transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            List <User> list = session.createQuery("from User",User.class).list();
            transaction.commit();
            return list;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();
            session.createNativeQuery(" TRUNCATE FROM users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
