package com.yaguar.todo.api.dto.response;

import com.yaguar.todo.entity.ColumnEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardResponse {
    private Long id;
    private String name;
    private Long userId;
}
