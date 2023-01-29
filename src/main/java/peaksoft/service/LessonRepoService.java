package peaksoft.service;

import peaksoft.entity.Lesson;

public interface LessonRepoService {
    String saveLesson(Long  courseId, Lesson lesson);
    boolean updateLesson(Long lessonId, Lesson lesson);
    Lesson getLessonById(Long lessonId);
    boolean getLessonsByCourseId(Long courseId);
}
