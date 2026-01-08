package com.yaguar.todo.repository;

import com.yaguar.todo.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeEntityRepository extends JpaRepository<TypeEntity,Long> {
    List<TypeEntity> findAllByUser_Id (long userId);

    TypeEntity findByIdAndUser_Id(long id, long userId);
}
