package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.TaskAddRequest;
import com.yaguar.todo.api.dto.request.TaskUpdateRequest;
import com.yaguar.todo.api.dto.response.TaskResponse;
import com.yaguar.todo.dao.TaskDao;
import com.yaguar.todo.mapper.TaskMapper;
import com.yaguar.todo.repository.ColumnRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class TaskServiceImpl implements TaskService {
    private final TaskMapper taskMapper;
    private final TaskDao taskDao;
    private final ColumnRepository columnRepository;

    @Override
    public List<TaskResponse> findAll() {
        return taskMapper.toResponse(taskDao.findAll());
    }

    @Override
    public TaskResponse findById(Long id) {
        var task = taskDao.findById(id);
        if (task == null)
            throw new EntityNotFoundException("Task not found");

        return taskMapper.toResponse(task);
    }

    @Override
    public Long addTask(TaskAddRequest taskAddRequest) {
        var column = columnRepository.findById(taskAddRequest.columnId())
                .orElseThrow(() -> new EntityNotFoundException("Column not found"));

        var task = taskMapper.toEntity(taskAddRequest);

        return taskDao.addTask(task);
    }

    @Override
    public void deleteById(Long id) {
        var task = taskDao.findById(id);
        if (task == null)
            throw new EntityNotFoundException("Task not found");

        taskDao.deleteById(id);
    }

    @Override
    public void updateTask(TaskUpdateRequest taskUpdateRequest, Long id) {
        var task = taskDao.findById(id);
        if (task == null)
            throw new EntityNotFoundException("Task not found");

        taskMapper.updateEntity(taskUpdateRequest, task);

        taskDao.updateTask(task);
    }
}
