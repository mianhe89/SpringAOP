package com.example.springaop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity

public class Schedule extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String manager;

    @Column
    private Integer password;

    public Schedule(String title, String content, String manager, Integer password) {
        this.title = title;
        this.content = content;
        this.manager = manager;
        this.password = password;
    }
}
