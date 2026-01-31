package com.yaguar.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Table( name = "boards")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
