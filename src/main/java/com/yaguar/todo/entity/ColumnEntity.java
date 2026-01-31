package com.yaguar.todo.entity;

import jakarta.persistence.*;
import lombok.*;

@Table( name = "columns")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ColumnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "board_id", nullable = false)
    private BoardEntity board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "type_id", nullable = false)
    private TypeEntity type;

}
