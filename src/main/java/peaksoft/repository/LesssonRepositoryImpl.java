package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class LesssonRepositoryImpl implements LessonRepos{

    private final EntityManager entityManager= HibernateConfig.getEntityManager();

    @Override
    public String saveLesson(Long courseId, Lesson lesson) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        lesson.setCourse(course);
        entityManager.persist(lesson);
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!";
    }

    @Override
    public void updateLesson(Long lessonId, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, lessonId);
        lesson1.setVideoLink(lesson.getVideoLink());
        lesson1.setCourse(lesson.getCourse());
        lesson1.setTask(lesson.getTask());
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    public void getLessonsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("select l from Lesson l join Course c on course.id=lesson.id where c.id:courseId ");
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
