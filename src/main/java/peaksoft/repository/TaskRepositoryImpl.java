package peaksoft.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepos,AutoCloseable {
    private final EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public void saveTask(Task task, Long lessonId) {
        List<Task> taskList = new ArrayList<>();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        taskList.addAll(lesson.getTask());
        taskList.add(task);
        lesson.setTask(taskList);
        entityManager.persist(task);
        entityManager.merge(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Task updateTask(Long Id, Task task) {
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class,Id);
        task1.setName(task.getName());
        task1.setDeadline(task.getDeadline());
        task1.setTask(task.getTask());
        entityManager.getTransaction().commit();
        entityManager.close();
        return task;
    }

    @Override
    public String getAllTaskByLessonId(Long id) {
        List<Task> taskList = new ArrayList<>();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        taskList.addAll(lesson.getTask());
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public Task deleteTaskById(Long id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
