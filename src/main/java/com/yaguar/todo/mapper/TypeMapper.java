package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.TypeAddRequest;
import com.yaguar.todo.api.dto.request.TypeUpdateRequest;
import com.yaguar.todo.api.dto.response.TypeResponse;
import com.yaguar.todo.entity.TypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper( componentModel = "spring")
public interface TypeMapper {
    @Mapping(source = "user.id", target = "userId")
    TypeResponse toResponse(TypeEntity typeEntity);

    @Mapping(source = "userId", target = "user.id")
    TypeEntity toEntity(TypeAddRequest typeAddRequest);

    List<TypeResponse> toResponseList(List<TypeEntity> typeEntities);

    void update(TypeUpdateRequest typeUpdateRequest, @MappingTarget TypeEntity typeEntity);
}
