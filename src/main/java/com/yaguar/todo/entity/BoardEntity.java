package com.yaguar.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Table( name = "boards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
