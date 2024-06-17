package com.example.springaop.service;

import com.example.springaop.dto.ReqComment;
import com.example.springaop.dto.ResComment;
import com.example.springaop.entity.Comment;
import com.example.springaop.entity.Schedule;
import com.example.springaop.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleService scheduleService;

    public CommentService(CommentRepository commentRepository, ScheduleService scheduleService) {
        this.commentRepository = commentRepository;
        this.scheduleService = scheduleService;
    }

    public ResComment createComment(Long id, ReqComment reqComment) {
        Schedule schedule = scheduleService.findByScheduleId(id); // 일정이 있으면
        // 일정에 대한 정보를 코맨드가 가져감
        Comment comment = new Comment(reqComment.getComment(), reqComment.getUserName(),
                schedule);
        commentRepository.save(comment);
        return new ResComment(comment);
    }
}