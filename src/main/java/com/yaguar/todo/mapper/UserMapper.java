package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.UserRequest;
import com.yaguar.todo.api.dto.response.UserResponse;
import com.yaguar.todo.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    UserEntity toEntity(UserRequest userEntity);

    UserResponse toResponse(UserEntity userEntity);
}
