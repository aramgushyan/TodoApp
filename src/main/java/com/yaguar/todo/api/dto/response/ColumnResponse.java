package com.yaguar.todo.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ColumnResponse {
    private Long id;
    private Integer orderNumber;
    private Long boardId;
    private Long typeId;
}
