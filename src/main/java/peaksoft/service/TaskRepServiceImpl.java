package peaksoft.service;

import peaksoft.entity.Task;
import peaksoft.repository.TaskRepos;
import peaksoft.repository.TaskRepositoryImpl;

public class TaskRepServiceImpl implements TaskReposService{
    TaskRepos taskRepos =new TaskRepositoryImpl();
    @Override
    public boolean saveTask(Task task, Long lessonid) {
        taskRepos.saveTask(task,lessonid);
        return false;
    }

    @Override
    public Task updateTask(Long Id, Task task) {
        return taskRepos.updateTask(Id,task);
    }

    @Override
    public String getAllTaskByLessonId(Long id) {
        return taskRepos.getAllTaskByLessonId(id);
    }

    @Override
    public Task deleteTaskById(Long id) {
        return taskRepos.deleteTaskById(id);
    }
}
