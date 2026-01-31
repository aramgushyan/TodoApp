package com.yaguar.todo.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnAddRequest {
    private Integer orderNumber;
    private Long boardId;
    private Long typeId;
}
