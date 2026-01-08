package com.yaguar.todo.repository;

import com.yaguar.todo.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardEntityRepository extends JpaRepository<BoardEntity,Long> {
    List<BoardEntity> findAllByUser_Id(long userId);
    BoardEntity findByIdAndUser_Id(long id, long userId);
    BoardEntity findByIdAndName(long id, String name);
}
