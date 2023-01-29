package peaksoft.service;

import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepos;
import peaksoft.repository.LesssonRepositoryImpl;

public class LessonRepServiceImpl implements LessonRepoService{
    LessonRepos lessonRepos = new LesssonRepositoryImpl();
    @Override
    public String saveLesson(Long courseId, Lesson lesson) {
        return lessonRepos.saveLesson(courseId,lesson) ;
    }

    @Override
    public boolean updateLesson(Long lessonId, Lesson lesson) {
        lessonRepos.updateLesson(lessonId,lesson);
        return false;
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        return lessonRepos.getLessonById(lessonId);
    }

    @Override
    public boolean getLessonsByCourseId(Long courseId) {
        lessonRepos.getLessonsByCourseId(courseId);
        return false;
    }
}
