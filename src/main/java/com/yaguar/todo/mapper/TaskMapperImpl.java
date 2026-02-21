package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.TaskAddRequest;
import com.yaguar.todo.api.dto.request.TaskUpdateRequest;
import com.yaguar.todo.api.dto.response.TaskResponse;
import com.yaguar.todo.entity.ColumnEntity;
import com.yaguar.todo.entity.TaskEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
class TaskMapperImpl implements TaskMapper {
    @Override
    public TaskEntity toEntity(TaskAddRequest taskAddRequest) {
        var task =  new TaskEntity();
        var columnEntity = new ColumnEntity();

        columnEntity.setId(taskAddRequest.columnId());

        task.setTitle(taskAddRequest.title());
        task.setDescription(taskAddRequest.description());
        task.setCreatedAt(LocalDateTime.now());
        task.setColumn(columnEntity);

        return task;
    }

    @Override
    public TaskResponse toResponse(TaskEntity taskEntity) {
        var task = new TaskResponse();

        task.setId(taskEntity.getId());
        task.setTitle(taskEntity.getTitle());
        task.setDescription(taskEntity.getDescription());
        task.setCreatedAt(taskEntity.getCreatedAt());
        task.setUpdatedAt(taskEntity.getUpdatedAt());
        task.setColumnId(taskEntity.getColumn().getId());

        return task;
    }

    @Override
    public TaskEntity updateEntity(TaskUpdateRequest taskUpdateRequest, TaskEntity taskEntity) {
        var columnEntity = new ColumnEntity();
        columnEntity.setId(taskUpdateRequest.columnId());

        taskEntity.setTitle(taskUpdateRequest.title());
        taskEntity.setDescription(taskUpdateRequest.description());
        taskEntity.setUpdatedAt(LocalDateTime.now());
        taskEntity.setColumn(columnEntity);

        return taskEntity;
    }

    @Override
    public List<TaskResponse> toResponse(List<TaskEntity> taskEntities) {
        return taskEntities.stream()
                .map((taskEntity) -> toResponse(taskEntity))
                .toList();
    }
}
