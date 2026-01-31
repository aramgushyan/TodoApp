package com.yaguar.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Table (name = "types")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable = false )
    private UserEntity user;
}
