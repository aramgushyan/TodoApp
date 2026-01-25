package com.yaguar.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Table (name = "types")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @JoinColumn(name = "user_id",  nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
