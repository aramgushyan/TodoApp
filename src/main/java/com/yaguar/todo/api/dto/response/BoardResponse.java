package com.yaguar.todo.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponse {
    private Long id;
    private String name;
    private Long userId;
}
