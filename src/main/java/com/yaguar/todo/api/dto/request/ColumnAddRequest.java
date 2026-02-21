package com.yaguar.todo.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ColumnAddRequest(
        @NotNull(message = "OrderNumber cannot be null")
        @Positive(message = "OrderNumber cannot be negative number")
        Integer orderNumber,
        @Positive(message = "TypeId cannot be negative number")
        Long typeId) {
}
