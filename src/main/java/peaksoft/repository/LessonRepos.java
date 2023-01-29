package peaksoft.repository;

import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

public interface LessonRepos {
    String saveLesson(Long  courseId, Lesson lesson);
    void updateLesson(Long lessonId, Lesson lesson);
    Lesson getLessonById(Long lessonId);
    void getLessonsByCourseId(Long courseId);
}
