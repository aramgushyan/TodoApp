package com.yaguar.todo.api.dto.response;

import com.yaguar.todo.entity.ColumnEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TaskResponse {
    private Long id;
    private Long columnId;

    private String title;
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
