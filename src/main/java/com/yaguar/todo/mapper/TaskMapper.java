package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.TaskAddRequest;
import com.yaguar.todo.api.dto.request.TaskUpdateRequest;
import com.yaguar.todo.api.dto.response.TaskResponse;
import com.yaguar.todo.entity.TaskEntity;

import java.util.List;

public interface TaskMapper {

    TaskEntity toEntity(TaskAddRequest taskAddRequest);

    TaskResponse toResponse(TaskEntity taskEntity);

    TaskEntity updateEntity(TaskUpdateRequest taskUpdateRequest, TaskEntity taskEntity);

    List<TaskResponse> toResponse(List<TaskEntity> taskEntities);
}
