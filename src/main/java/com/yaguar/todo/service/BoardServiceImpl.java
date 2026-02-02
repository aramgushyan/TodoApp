package com.yaguar.todo.service;

import com.yaguar.todo.api.dto.request.BoardAddRequest;
import com.yaguar.todo.api.dto.request.BoardUpdateRequest;
import com.yaguar.todo.api.dto.response.BoardResponse;
import com.yaguar.todo.entity.UserEntity;
import com.yaguar.todo.mapper.BoardMapper;
import com.yaguar.todo.repository.BoardRepository;
import com.yaguar.todo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final BoardMapper boardMapper;

    @Override
    public List<BoardResponse> findAllByUserId(Long userId) {
        var userEntity = findUserById(userId);

        var boards = boardRepository.findAllByUser(userEntity);

        return boardMapper.toResponseList(boards);
    }

    @Override
    public BoardResponse findByIdAndUserId(Long id, Long userId) {
        var userEntity = findUserById(userId);

        var board = boardRepository.findByIdAndUser(id, userEntity)
                .orElseThrow( () -> new EntityNotFoundException("Board not found"));

        return boardMapper.toResponse(board);
    }

    @Override
    public void deleteByIdAndUserId(Long id, Long userId) {
        var userEntity = findUserById(userId);

        var board = boardRepository.findByIdAndUser(id, userEntity)
                .orElseThrow( () -> new EntityNotFoundException("Board not found"));

        boardRepository.delete(board);
    }

    @Override
    public Long addBoard(Long userId, BoardAddRequest boardAddRequest) {
        var userEntity = findUserById(userId);

        var board = boardMapper.toEntity(boardAddRequest);

        boardRepository.save(board);

        return board.getId();
    }

    @Override
    public void updateBoard(BoardUpdateRequest boardUpdateRequest, Long userId, Long boardId) {
        var userEntity = findUserById(userId);

        var board = boardRepository.findByIdAndUser(boardId, userEntity)
                .orElseThrow( () -> new EntityNotFoundException("Board not found"));

        boardMapper.updateBoard(boardUpdateRequest, board);

        boardRepository.save(board);
    }

    private UserEntity findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow( () -> new EntityNotFoundException("User not found"));
    }
}
