package com.yaguar.todo.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeAddRequest {
    @NotBlank(message = "Type name cannot be null or empty")
    @Size(max = 50, message = "Max size is 50 symbols")
    private String name;

    @NotBlank(message = "Description cannot be null or empty")
    @Size(max = 200, message = "Max size is 200 symbols")
    private String description;
}
