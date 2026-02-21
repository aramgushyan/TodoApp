package com.yaguar.todo.repository;

import com.yaguar.todo.entity.TypeEntity;
import com.yaguar.todo.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    @EntityGraph(attributePaths = {"columns"})
    List<TypeEntity> findAllByUser(UserEntity user);
    @EntityGraph(attributePaths = {"columns"})
    Optional<TypeEntity> findByIdAndUser(Long id,UserEntity user);
    void deleteByIdAndUser(Long id, UserEntity user);
}
