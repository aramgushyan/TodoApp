package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.BoardAddRequest;
import com.yaguar.todo.api.dto.request.BoardUpdateRequest;
import com.yaguar.todo.api.dto.response.BoardResponse;

import java.util.List;

public interface BoardService {
    List<BoardResponse> findAllByUserId(Long userId);

    BoardResponse findByIdAndUserId(Long id, Long userId);

    void deleteByIdAndUserId(Long id, Long userId);

    Long addBoard(BoardAddRequest boardAddRequest);

    void updateBoard(BoardUpdateRequest boardUpdateRequest, Long userId, Long boardId);
}
