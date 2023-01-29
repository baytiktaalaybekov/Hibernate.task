package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepos{
    private final EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public void saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Instructor updateInstructor(Long idInstructor, Instructor instructor) {
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, idInstructor);
        instructor1.setFirsName(instructor.getFirsName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        instructor1.setCourses(instructor.getCourses());
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public Instructor getInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor;
    }

    @Override
    public String getInstructorByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery(
                "select i from Instructors i join Course c on course.id=instructor.id where c.id:courseId")
                        .setParameter("id",courseId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully find!";
    }

    @Override
    public Instructor deleteInstructorById(Long instructorId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        List<Instructor>instructors = new ArrayList<>(course.getInstructors());
        List<Course> courses = new ArrayList<>(instructor.getCourses());
        instructors.add(instructor);
        courses.add(course);
        instructor.setCourses(courses);
        course.setInstructors(instructors);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
