package com.yaguar.todo.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnAddRequest {
    @NotNull(message = "OrderNumber cannot be null")
    @Positive(message = "OrderNumber cannot be negative number")
    private Integer orderNumber;

    @Positive(message = "TypeId cannot be negative number")
    private Long typeId;
}
