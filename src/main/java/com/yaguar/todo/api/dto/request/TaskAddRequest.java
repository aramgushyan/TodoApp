package com.yaguar.todo.api.dto.request;

import com.yaguar.todo.entity.ColumnEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskAddRequest {
    private String title;
    private String description;

    private Long columnId;
}
