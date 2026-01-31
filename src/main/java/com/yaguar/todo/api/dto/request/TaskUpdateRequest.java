package com.yaguar.todo.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskUpdateRequest {
    private String title;
    private String description;

    private Long columnId;
}
