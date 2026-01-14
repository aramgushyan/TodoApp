package com.yaguar.todo.api.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardAddRequest {
    String name;
    Long userId;
}
