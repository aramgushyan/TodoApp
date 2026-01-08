package com.yaguar.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "columns")
public class ColumnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "board_id", nullable = false )
    private BoardEntity board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "type_id", nullable = false )
    private TypeEntity type;

}
