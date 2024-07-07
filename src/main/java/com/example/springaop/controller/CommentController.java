package com.example.springaop.controller;

import com.example.springaop.dto.ReqComment;
import com.example.springaop.filter.AuthFilter;
import com.example.springaop.jwt.JwtUtil;
import com.example.springaop.service.CommentService;
import com.example.springaop.dto.ResComment;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final JwtUtil jwtUtil;


    // 여기서 특정 메서드

    //댓글 등록
    @PostMapping("/comments/{ScheduleId}")
    public ResComment postComment(@PathVariable Long ScheduleId,
                                  @RequestBody ReqComment ReqComment,
                                  @CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue) {
        if (ScheduleId == null) {
            throw new RuntimeException("잘못된 입력입니다.");
        } // 코멘트가 비어있을경우 , ID를 URL 로 입력받지 못한경우
        return commentService.createComment(ScheduleId, ReqComment);
    }

    @PutMapping("/comments/{ScheduleId}/{CommentId}")
    public ResponseEntity<ResComment> updateComment(
            @RequestBody ReqComment ReqComment,
            @PathVariable Long ScheduleId,
            @PathVariable Long CommentId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.updateComment(ScheduleId, CommentId, ReqComment));

    }

    @DeleteMapping("/comments/{ScheduleId}/{CommentId}")
    public ResponseEntity<String> deleteComments(
            @PathVariable Long ScheduleId,
            @PathVariable Long CommentId) {
        commentService.deleteComment(ScheduleId, CommentId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("삭제에 성공했습니다.");
    }
}
