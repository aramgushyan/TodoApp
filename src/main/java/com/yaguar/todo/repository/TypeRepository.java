package com.yaguar.todo.repository;

import com.yaguar.todo.entity.TypeEntity;
import com.yaguar.todo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    List<TypeEntity> findAllByUser(UserEntity user);
    Optional<TypeEntity> findByIdAndUser(Long id,UserEntity user);
    void deleteByIdAndUser(Long id, UserEntity user);
}
