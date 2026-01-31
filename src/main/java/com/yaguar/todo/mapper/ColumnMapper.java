package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.ColumnAddRequest;
import com.yaguar.todo.api.dto.request.ColumnUpdateRequest;
import com.yaguar.todo.api.dto.response.ColumnResponse;
import com.yaguar.todo.entity.ColumnEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColumnMapper {
    @Mapping(source = "boardId",target = "board.id")
    @Mapping(source = "typeId", target = "type.id")
    public ColumnEntity toEnity(ColumnAddRequest request);

    @Mapping(source = "board.id", target = "boardId")
    @Mapping(source = "type.id", target = "typeId")
    public ColumnResponse toResponse(ColumnEntity entity);

    List<ColumnResponse> toResponseList(List<ColumnEntity> entity);

    void updateEntity(ColumnUpdateRequest request, @MappingTarget ColumnEntity entity);
}
