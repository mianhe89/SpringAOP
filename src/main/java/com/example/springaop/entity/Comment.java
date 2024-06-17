package com.example.springaop.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
public class Comment extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id") // 매핑 관계 설정
    private Schedule scheduleId;

    @Column
    private String comment;

    @Column
    private String userName;

    public Comment(String comment, String userName, Schedule scheduleId) {
        this.comment = comment;
        this.userName = userName;
        this.scheduleId = scheduleId;
    }
}
