package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.TaskRequest;
import com.yaguar.todo.api.dto.response.TaskResponse;
import com.yaguar.todo.entity.TaskEntity;

public interface TaskMapper {

    TaskEntity toEntity(TaskRequest taskRequest);

    TaskResponse toResponse(TaskEntity taskEntity);

    TaskEntity updateEntity(TaskRequest taskRequest,  TaskEntity taskEntity);
}
