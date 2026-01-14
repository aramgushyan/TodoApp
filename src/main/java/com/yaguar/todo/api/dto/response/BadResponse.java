package com.yaguar.todo.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BadResponse {
    Integer code;
    String message;
}
