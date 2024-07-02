package com.example.springaop.service;

import com.example.springaop.dto.ReqComment;
import com.example.springaop.dto.ResComment;
import com.example.springaop.entity.Comment;
import com.example.springaop.entity.Schedule;
import com.example.springaop.repository.CommentRepository;
import com.example.springaop.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ResComment createComment(Long id, ReqComment reqComment) {
        Schedule schedule = scheduleRepository.findScheduleById(id).orElseThrow(
                () -> new RuntimeException("일정이 없습니다.")
        ); // 일정이 있으면
        // 일정에 대한 정보를 코맨드가 가져감
        Comment comment = new Comment(reqComment.getComment(), reqComment.getUserName(),
                schedule);
        commentRepository.save(comment);
        return new ResComment(comment);
    }

    @Transactional
    public ResComment updateComment(Long ScheduleId, Long CommentId, @RequestBody ReqComment ReqComment) {
        Comment comment = commentRepository.findByIdAndScheduleId(CommentId, ScheduleId)
                .orElseThrow(() -> new RuntimeException("해당 일정 또는 코맨트가 없습니다")
                );
        comment.changeComment(ReqComment.getComment());
        commentRepository.save(comment);
        return new ResComment(comment);
    }
}