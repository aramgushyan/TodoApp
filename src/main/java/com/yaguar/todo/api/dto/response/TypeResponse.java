package com.yaguar.todo.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeResponse {
    private Long id;

    private String name;
    private String description;

    private Long userId;
}
