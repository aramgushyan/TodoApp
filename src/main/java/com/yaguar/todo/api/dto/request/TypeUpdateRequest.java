package com.yaguar.todo.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeUpdateRequest {
    private String name;
    private String description;
}
