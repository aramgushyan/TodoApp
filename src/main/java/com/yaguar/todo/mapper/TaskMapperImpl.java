package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.TaskRequest;
import com.yaguar.todo.api.dto.response.TaskResponse;
import com.yaguar.todo.entity.TaskEntity;

public class TaskMapperImpl implements TaskMapper {
    @Override
    public TaskEntity toEntity(TaskRequest taskRequest) {
        return null;
    }

    @Override
    public TaskResponse toResponse(TaskEntity taskEntity) {
        return null;
    }

    @Override
    public TaskEntity updateEntity(TaskRequest taskRequest, TaskEntity taskEntity) {
        return null;
    }
}
