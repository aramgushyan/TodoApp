package com.yaguar.todo.repository;

import com.yaguar.todo.entity.BoardEntity;
import com.yaguar.todo.entity.ColumnEntity;
import com.yaguar.todo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ColumnRepository extends JpaRepository<ColumnEntity, Long> {
    List<ColumnEntity> findAllByBoard(BoardEntity board);
    Optional<ColumnEntity> findByIdAndBoard(long id, BoardEntity board);
    void deleteByIdAndBoard(Long id, BoardEntity board);
}
