package com.yaguar.todo.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BoardAddRequest(
        @NotBlank(message = "Board name cannot be null or empty")
        @Size(max = 50, message = "Max size is 50 symbols")
        String name){
}
