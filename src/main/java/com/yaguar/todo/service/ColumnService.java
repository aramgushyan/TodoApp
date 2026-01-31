package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.ColumnAddRequest;
import com.yaguar.todo.api.dto.request.ColumnUpdateRequest;
import com.yaguar.todo.api.dto.response.ColumnResponse;
import com.yaguar.todo.entity.BoardEntity;

import java.util.List;

public interface ColumnService {
    public List<ColumnResponse> findAllByBoardId(Long boardId);

    public ColumnResponse findByIdAndBoardId(Long id,  Long boardId);

    public void deleteByIdAndBoardId(Long id, Long boardId);

    public Long addColumn(ColumnAddRequest columnAddRequest);

    public void updateColumn(Long id, Long boardId, ColumnUpdateRequest columnUpdateRequest);
}
