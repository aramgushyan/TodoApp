package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.BoardAddRequest;
import com.yaguar.todo.api.dto.request.BoardUpdateRequest;
import com.yaguar.todo.api.dto.response.BoardResponse;
import com.yaguar.todo.entity.BoardEntity;
import com.yaguar.todo.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface BoardEntityService {
    List<BoardResponse> findAllByUser(Long userId);

    BoardResponse findByIdAndUser(Long id, Long userId);

    void removeByIdAndUserId(Long id, Long userId);

    Long addBoardEntity(BoardAddRequest boardAddRequest);

    void updateBoardEntity(BoardUpdateRequest boardUpdateRequest, Long userId, Long boardId);
}
