package com.yaguar.todo.repository;

import com.yaguar.todo.entity.ColumnEntity;
import com.yaguar.todo.entity.TaskEntity;
import com.yaguar.todo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findAllByColumn(ColumnEntity columnEntity);
    Optional<TaskEntity> findByIdAndColumn(long id, ColumnEntity columnEntity);
    void deleteByIdAndColumn(Long id, ColumnEntity column);
}
