package com.yaguar.todo.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ColumnUpdateRequest(
        @NotNull(message = "OrderNumber cannot be null")
        @Positive(message = "OrderNumber cannot be negative number")
        Integer orderNumber){
}
