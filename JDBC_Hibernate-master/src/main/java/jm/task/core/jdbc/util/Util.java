package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class Util {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "jdbc:mysql://localhost:3306/users?useSSL=false&allowMultiQueries=true&serverTimezone=UTC";
   // "jdbc:mysql://localhost/db?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

    private static final String LOGIN = "root";
    private static final String PASSWORD2 = "root";
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration configuration = getConfiguration();
            configuration.addAnnotatedClass(User.class);




            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    private  static  Configuration getConfiguration (){
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER,DRIVER);
        properties.put(Environment.URL,HOST);
        properties.put(Environment.USER,LOGIN);
        properties.put(Environment.PASS,PASSWORD2);
        properties.put(Environment.SHOW_SQL,true);
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
        properties.put(Environment.HBM2DDL_AUTO, "");
        properties.put(Environment.POOL_SIZE, 10);
        configuration.setProperties(properties);

        return configuration;
    }
}













