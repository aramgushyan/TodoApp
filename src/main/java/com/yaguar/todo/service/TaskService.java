package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.TaskAddRequest;
import com.yaguar.todo.api.dto.request.TaskUpdateRequest;
import com.yaguar.todo.api.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> findAll();
    TaskResponse findById(Long id);
    Long addTask(TaskAddRequest taskAddRequest);
    void deleteById(Long id);
    void updateTask(TaskUpdateRequest taskUpdateRequest, Long id);
}
