package com.yaguar.todo.dao;

import com.yaguar.todo.entity.TaskEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class TaskDaoImpl implements TaskDao {
    @PersistenceContext
    private EntityManager em;

    public List<TaskEntity> findAll() {
        return em.createQuery("SELECT t FROM TaskEntity t", TaskEntity.class).getResultList();
    }

    public TaskEntity findById(Long id) {
        return em.find(TaskEntity.class, id);
    }

    public Long addTask(TaskEntity task) {
        em.persist(task);
        return task.getId();
    }

    public void deleteById(Long taskId) {
        var task = em.find(TaskEntity.class, taskId);

        if (task != null)
            em.remove(task);
    }

    public void updateTask(TaskEntity task) {
        var oldTask = em.find(TaskEntity.class, task.getId());

        if (oldTask != null)
            em.merge(task);
    }
}
