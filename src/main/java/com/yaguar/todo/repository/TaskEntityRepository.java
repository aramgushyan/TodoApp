package com.yaguar.todo.repository;

import com.yaguar.todo.entity.ColumnEntity;
import com.yaguar.todo.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskEntityRepository extends JpaRepository<TaskEntity,Long> {
    List<TaskEntity> findAllByColumn(ColumnEntity columnEntity);

    Optional<TaskEntity> findByIdAndColumn(long id, ColumnEntity columnEntity);
}
