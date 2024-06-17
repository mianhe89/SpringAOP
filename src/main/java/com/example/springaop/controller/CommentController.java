package com.example.springaop.controller;

import com.example.springaop.dto.ReqComment;
import com.example.springaop.dto.ResComment;
import com.example.springaop.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //댓글 등록
    @PostMapping("/comments/{ScheduleId}")
    public ResComment postComment(@PathVariable Long ScheduleId, @RequestBody ReqComment ReqComment) {
        return commentService.createComment(ScheduleId, ReqComment);
    }
}
