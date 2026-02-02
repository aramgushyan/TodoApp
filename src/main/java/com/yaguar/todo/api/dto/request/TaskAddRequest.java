package com.yaguar.todo.api.dto.request;

import com.yaguar.todo.entity.ColumnEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskAddRequest {
    @NotBlank(message = "Title cannot be null or empty")
    @Size(max = 50, message = "Max size is 50 symbols")
    private String title;

    @NotBlank(message = "Description cannot be null or empty")
    @Size(max = 200, message = "Max size is 200 symbols")
    private String description;

    @NotNull(message = "ColumnId cannot be null")
    @Positive(message = "ColumnId cannot be negative number")
    private Long columnId;
}
