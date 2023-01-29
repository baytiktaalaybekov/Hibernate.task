package peaksoft.service;

import peaksoft.entity.Task;

public interface TaskReposService {
    boolean saveTask(Task task, Long lessonid);
    Task updateTask(Long Id,Task task);

    String getAllTaskByLessonId(Long id );

    Task deleteTaskById(Long id);
}
