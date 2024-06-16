package com.example.springaop.dto;

import com.example.springaop.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ResScheduleDto {
    private String title;
    private String content;
    private String manager;
    private Integer password;
    private LocalDateTime createdAt;

    public ResScheduleDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.manager = schedule.getManager();
        this.password = schedule.getPassword();
        this.createdAt = schedule.getCreatedAt();
    }
}
