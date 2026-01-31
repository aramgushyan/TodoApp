package com.yaguar.todo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table( name = "tasks" )
@Getter
@Setter
@NoArgsConstructor
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    private String title;

    @Column( nullable = false )
    private String description;

    @Column( nullable = false )
    private LocalDateTime createdAt;

    @Column()
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "column_id")
    private ColumnEntity column;
}
