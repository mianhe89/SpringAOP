package com.example.springaop.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column // 매핑 관계 설정
    private Long scheduleId;

    @Column
    private String comment;

    @Column
    private String userName;


}
