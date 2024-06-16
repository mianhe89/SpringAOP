package com.example.springaop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @Column
    private LocalDateTime deletedAt;

    public Schedule(String title, String content, String manager, Integer password) {
        this.title = title;
        this.content = content;
        this.manager = manager;
        this.password = password;
    }

    public void changeSchedule(String title, String content, String manager) {
        this.title = title;
        this.content = content;
        this.manager = manager;
    }

    public void isDelete() {
        this.deletedAt = LocalDateTime.now();
    }
}
