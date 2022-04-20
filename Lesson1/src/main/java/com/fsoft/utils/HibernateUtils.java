package com.fsoft.utils;

import com.fsoft.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    private static Configuration configuration;
    private SessionFactory sessionFactory;

    public HibernateUtils(){
        configure();
    }
    private static void configure() {
        // load configuration
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Group.class);
    }

    private SessionFactory buildSessionFactory(){
        if (null==sessionFactory || sessionFactory.isClosed()){
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return  sessionFactory;
    }
    public void closeFactory() {
        if (null != sessionFactory && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

    public Session openSession() {
        buildSessionFactory();
        return sessionFactory.openSession();
    }
}
