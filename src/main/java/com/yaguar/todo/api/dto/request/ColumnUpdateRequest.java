package com.yaguar.todo.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
public class ColumnUpdateRequest {
    @NotNull(message = "OrderNumber cannot be null")
    @Positive(message = "OrderNumber cannot be negative number")
    private Integer orderNumber;
}
