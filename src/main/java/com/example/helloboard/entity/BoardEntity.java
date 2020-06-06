package com.example.helloboard.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="board")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;
    @Column(length = 300)
    private String title;
    @Column(length = 3000)
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
