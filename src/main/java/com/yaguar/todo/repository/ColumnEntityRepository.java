package com.yaguar.todo.repository;

import com.yaguar.todo.entity.ColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnEntityRepository extends JpaRepository<ColumnEntity,Long> {
    List<ColumnEntity> findAllByBoard_Id(long boardId);
    ColumnEntity findByIdAndBoard_Id(long id, long boardId);
}
