package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;

import java.util.List;
import java.util.Objects;

public class CourseRepositoryImpl implements CourseRepository{

    private final EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public void saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Course getCourseById(Long courseId) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        entityManager.getTransaction().begin();
        List<Course> courseC = entityManager.createQuery("select c from Course c", Course.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseC;
    }

    @Override
    public Course update(Long courseId, Course course) {
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, courseId);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course1.getDuration());
        course1.setCreateAt(course.getCreateAt());
        course1.setImageLink(course.getImageLink());
        course1.setDescription(course1.getDescription());
        course1.setInstructors(course.getInstructors());
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public String deleteCourseById(Long courseId) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getCourseName()+ " is deleted!";
    }

    @Override
    public Course getByCourseName(String name) {
        entityManager.getTransaction().begin();
        Object courseName = entityManager.createQuery(
                "select c from Course c where courseName=:name").
                setParameter("courseName",name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return (Course) courseName;
    }
}
