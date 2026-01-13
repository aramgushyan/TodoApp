package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.UserAddRequest;
import com.yaguar.todo.api.dto.request.UserUpdateRequest;
import com.yaguar.todo.api.dto.response.UserResponse;
import com.yaguar.todo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserAddRequest userEntity);

    UserResponse toResponse(UserEntity userEntity);

    List<UserResponse> toResponseList(List<UserEntity> userEntities);

    void updateEntityFromDto(UserUpdateRequest dto, @MappingTarget UserEntity entity);
}
