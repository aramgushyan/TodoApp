package com.yaguar.todo.api.dto.request;

import lombok.*;

@Getter
@Setter
public class BoardAddRequest {
    private String name;
    private Long userId;
}
