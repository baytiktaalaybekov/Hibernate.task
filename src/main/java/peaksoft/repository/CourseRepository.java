package peaksoft.repository;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);

    Course getCourseById(Long courseId);

    List<Course> getAllCourse();

    Course update(Long courseId, Course course);

    String deleteCourseById(Long courseId);

    Course getByCourseName(String name);

}



