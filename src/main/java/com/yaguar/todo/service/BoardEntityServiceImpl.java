package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.BoardAddRequest;
import com.yaguar.todo.api.dto.request.BoardUpdateRequest;
import com.yaguar.todo.api.dto.response.BoardResponse;
import com.yaguar.todo.entity.UserEntity;
import com.yaguar.todo.mapper.BoardMapper;
import com.yaguar.todo.repository.BoardEntityRepository;
import com.yaguar.todo.repository.UserEntityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardEntityServiceImpl implements BoardEntityService {
    private final BoardEntityRepository boardEntityRepository;
    private final UserEntityRepository userEntityRepository;
    private final BoardMapper boardMapper;

    @Override
    public List<BoardResponse> findAllByUser(Long userId) {
        var userEntity = userEntityRepository.findById(userId)
                .orElseThrow( () -> new EntityNotFoundException("User not found"));

        var boards = boardEntityRepository.findAllByUser(userEntity);

        return boardMapper.toResponseList(boards);
    }

    @Override
    public BoardResponse findByIdAndUser(Long id, Long userId) {
        var userEntity = userEntityRepository.findById(userId)
                .orElseThrow( () -> new EntityNotFoundException("User not found"));

        var board = boardEntityRepository.findByIdAndUser(id, userEntity)
                .orElseThrow( () -> new EntityNotFoundException("Board not found"));

        return boardMapper.toResponse(board);
    }

    @Override
    public void removeByIdAndUserId(Long id, Long userId) {
        var userEntity = userEntityRepository.findById(userId)
                .orElseThrow( () -> new EntityNotFoundException("User not found"));

        var board = boardEntityRepository.findByIdAndUser(id, userEntity)
                .orElseThrow( () -> new EntityNotFoundException("Board not found"));

        boardEntityRepository.delete(board);
    }

    @Override
    public Long addBoardEntity(BoardAddRequest boardAddRequest) {
        var userEntity = userEntityRepository.findById(boardAddRequest.getUserId())
                .orElseThrow( () -> new EntityNotFoundException("User not found"));

        var board = boardMapper.toEntity(boardAddRequest);

        boardEntityRepository.save(board);

        return board.getId();
    }

    @Override
    public void updateBoardEntity(BoardUpdateRequest boardUpdateRequest,  Long userId, Long boardId) {
        var userEntity = userEntityRepository.findById(userId)
                .orElseThrow( () -> new EntityNotFoundException("User not found"));

        var board = boardEntityRepository.findByIdAndUser(boardId, userEntity)
                .orElseThrow( () -> new EntityNotFoundException("Board not found"));

        boardMapper.updateBoard(boardUpdateRequest, board);
        boardEntityRepository.save(board);
    }
}
