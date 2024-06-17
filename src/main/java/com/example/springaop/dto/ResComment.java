package com.example.springaop.dto;

import com.example.springaop.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ResComment {
    Long id;
    Long scheduleId;
    String comment;
    String userName;
    LocalDateTime updatedAt;

    public ResComment(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.scheduleId = comment.getScheduleId().getId();
        this.userName = comment.getUserName();
        this.updatedAt = comment.getUpdatedAt();
    }
}
