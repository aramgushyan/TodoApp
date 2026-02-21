package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.ColumnAddRequest;
import com.yaguar.todo.api.dto.request.ColumnUpdateRequest;
import com.yaguar.todo.api.dto.response.ColumnResponse;
import com.yaguar.todo.entity.BoardEntity;
import com.yaguar.todo.entity.ColumnEntity;
import com.yaguar.todo.mapper.BoardMapper;
import com.yaguar.todo.mapper.ColumnMapper;
import com.yaguar.todo.repository.BoardRepository;
import com.yaguar.todo.repository.ColumnRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class ColumnServiceImpl implements ColumnService {
    private final ColumnRepository columnRepository;
    private final ColumnMapper columnMapper;
    private final BoardRepository boardRepository;

    @Override
    public List<ColumnResponse> findAllByBoardId(Long boardId) {
        var board = boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("Board not found"));

        return columnMapper.toResponseList(columnRepository.findAllByBoard(board));
    }

    @Override
    public ColumnResponse findByIdAndBoardId(Long id, Long boardId) {
        var board = findBoardById(boardId);

        var column = findColumnByIdAndBoard(id, board);

        return columnMapper.toResponse(column);
    }

    @Override
    public void deleteByIdAndBoardId(Long id, Long boardId) {
        var board = findBoardById(boardId);

        var column = findColumnByIdAndBoard(id, board);

        columnRepository.deleteByIdAndBoard(id, board);
    }

    @Override
    public Long addColumn(Long boardId,ColumnAddRequest columnAddRequest) {
        var board = findBoardById(boardId);

        var column = columnMapper.toEnity(columnAddRequest);
        columnRepository.save(column);

        return column.getId();
    }

    @Override
    public void updateColumn(Long id, Long boardId, ColumnUpdateRequest columnUpdateRequest) {
        var board = findBoardById(boardId);

        var column = findColumnByIdAndBoard(id, board);

        columnMapper.updateEntity(columnUpdateRequest, column);

        columnRepository.save(column);
    }

    private BoardEntity findBoardById(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("Board not found"));
    }

    private ColumnEntity findColumnByIdAndBoard(Long id, BoardEntity board) {
        return columnRepository.findByIdAndBoard(id, board)
                .orElseThrow(() -> new EntityNotFoundException("Column not found"));
    }
}
