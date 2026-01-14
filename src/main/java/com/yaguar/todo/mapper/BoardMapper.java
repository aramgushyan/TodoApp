package com.yaguar.todo.mapper;

import com.yaguar.todo.api.dto.request.BoardAddRequest;
import com.yaguar.todo.api.dto.request.BoardUpdateRequest;
import com.yaguar.todo.api.dto.response.BoardResponse;
import com.yaguar.todo.entity.BoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    @Mapping(source = "user.id", target = "userId")
    BoardResponse toResponse(BoardEntity boardEntity);

    List<BoardResponse> toResponseList(List<BoardEntity> boardEntities);

    @Mapping( source = "userId", target = "user.id")
    BoardEntity toEntity(BoardAddRequest boardAddResponse);

    void updateBoard(BoardUpdateRequest boardUpdateRequest, @MappingTarget BoardEntity boardEntity);
}
