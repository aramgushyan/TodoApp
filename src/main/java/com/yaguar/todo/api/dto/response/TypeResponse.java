package com.yaguar.todo.api.dto.response;

import com.yaguar.todo.entity.ColumnEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TypeResponse {
    private Long id;
    private String name;
    private String description;
    private Long userId;
    private List<ColumnResponse> columns;
}
