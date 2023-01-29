package peaksoft.repository;

import peaksoft.entity.Course;
import peaksoft.entity.Task;

public interface TaskRepos {

    void saveTask(Task task,Long lessonid);
    Task updateTask(Long Id,Task task);

    String getAllTaskByLessonId(Long id );

    Task deleteTaskById(Long id);
}
