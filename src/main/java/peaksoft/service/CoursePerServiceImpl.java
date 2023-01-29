package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.CourseRepositoryImpl;

import java.util.List;

public class CoursePerServiceImpl implements CourseRepService{

    CourseRepository courseRepository = new CourseRepositoryImpl();
    @Override
    public void saveCourse(Course course) {
        courseRepository.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public Course update(Long courseId, Course course) {
        return courseRepository.update(courseId,course);
    }

    @Override
    public String deleteCourseById(Long courseId) {
        return courseRepository.deleteCourseById(courseId);
    }

    @Override
    public Course getByCourseName(String name) {
        return courseRepository.getByCourseName(name);
    }
}
