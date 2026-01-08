package com.yaguar.todo.repository;

import com.yaguar.todo.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskEntityRepository extends JpaRepository<TaskEntity,Long> {
    List<TaskEntity> findAllByUser_Id(long userId);

    TaskEntity findByIdAndUser_Id(long id, long userId);
}
