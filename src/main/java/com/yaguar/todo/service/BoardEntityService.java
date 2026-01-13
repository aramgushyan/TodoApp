package com.yaguar.todo.service;

import com.yaguar.todo.entity.BoardEntity;
import com.yaguar.todo.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface BoardEntityService {
    List<BoardEntity> findAllByUser(Long id);

    Optional<BoardEntity> findByIdAndUser(Long id, Long user);

    Optional<BoardEntity> findByIdAndName(Long id, String name);

    void removeByIdAndUserId(Long id, UserEntity user);
}
