package com.yaguar.todo.dao;

import com.yaguar.todo.entity.TaskEntity;

import java.util.List;

public interface TaskDao {
    public List<TaskEntity> findAll();
    public TaskEntity findById(Long id);
    public Long addTask(TaskEntity task);
    public void deleteById(Long taskId);
    public void updateTask(TaskEntity task);
}
