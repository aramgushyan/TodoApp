package com.yaguar.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
