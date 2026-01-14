package com.yaguar.todo.repository;

import com.yaguar.todo.entity.BoardEntity;
import com.yaguar.todo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardEntityRepository extends JpaRepository<BoardEntity,Long> {
    List<BoardEntity> findAllByUser(UserEntity user);

    Optional<BoardEntity> findByIdAndUser(Long id, UserEntity user);
}
