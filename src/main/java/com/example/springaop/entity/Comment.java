package com.example.springaop.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
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
    private Schedule schedule;

    @Column
    @NotNull(message = "공백은 불가합니다.")
    private String comment;

    @Column
    private String userName;

    public Comment(String comment, String userName, Schedule scheduleId) {
        this.comment = comment;
        this.userName = userName;
        this.schedule = scheduleId;
    }

    public void changeComment(String comment) {
        this.comment = comment;
    }

}
