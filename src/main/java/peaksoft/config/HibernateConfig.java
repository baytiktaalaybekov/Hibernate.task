package peaksoft.config;

import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;


import java.sql.Driver;

import static org.hibernate.cfg.AvailableSettings.*;


public class HibernateConfig {
    public static EntityManager getEntityManager() {

        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        configuration.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(Environment.USER, "postgres");
        configuration.setProperty(Environment.PASS, "12345");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Task.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Lesson.class);
        return configuration.buildSessionFactory().createEntityManager();
//        Configuration configuration = new Configuration();
//        configuration.setProperty(DRIVER, "org.postgres.Driver");
//        configuration.setProperty(USER, "postgres");
//        configuration.setProperty(PASS, "12345");
//        configuration.setProperty(HBM2DDL_AUTO, "update");
//        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialcet");
//        configuration.setProperty(SHOW_SQL, "true");
//        configuration.addAnnotatedClass(Instructor.class);
//        configuration.addAnnotatedClass(Course.class);
//        configuration.addAnnotatedClass(Lesson.class);
//        configuration.addAnnotatedClass(Task.class);
//        return configuration.buildSessionFactory().createEntityManager();


    }
    }

