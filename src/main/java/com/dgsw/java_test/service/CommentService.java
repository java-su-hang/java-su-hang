package com.dgsw.java_test.service;

import com.dgsw.java_test.common.exception.NotFoundException;
import com.dgsw.java_test.dto.request.CreateCommentRequest;
import com.dgsw.java_test.dto.request.UpdateCommentRequest;
import com.dgsw.java_test.dto.response.CommentResponse;
import com.dgsw.java_test.dto.response.CommentsResponse;
import com.dgsw.java_test.entity.Comment;
import com.dgsw.java_test.entity.CommentCategory;
import com.dgsw.java_test.entity.Schedule;
import com.dgsw.java_test.repository.CommentRepository;
import com.dgsw.java_test.repository.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentsResponse getComments(
            Long scheduleId,
            CommentCategory commentCategory
    ) {
        if (!scheduleRepository.existsById(scheduleId)) {
            throw new NotFoundException("일정이 존재하지 않습니다.");
        }

        List<Comment> comments;
        if (commentCategory == null) {
            comments = commentRepository.findAllByScheduleScheduleId(scheduleId);
        } else {
            comments = commentRepository.findAllByScheduleScheduleIdAndCategory(scheduleId, commentCategory);
        }

        return CommentsResponse.from(comments);
    }

    @Transactional
    public CommentResponse createComment(
            Long scheduleId,
            CreateCommentRequest request
    ) {
        Schedule schedule = getSchedule(scheduleId);
        Comment comment = Comment.create(
                request.category(),
                request.content(),
                request.author(),
                schedule
        );

        return CommentResponse.from(commentRepository.save(comment));
    }

    @Transactional
    public CommentResponse updateComment(
            Long scheduleId,
            Long commentId,
            UpdateCommentRequest request
    ) {
        Comment comment = getComment(scheduleId, commentId);
        comment.update(request.category(), request.content());

        return CommentResponse.from(comment);
    }

    @Transactional
    public void deleteComment(
            Long scheduleId,
            Long commentId
    ) {
        commentRepository.delete(getComment(scheduleId, commentId));
    }

    private Schedule getSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NotFoundException("일정이 존재하지 않습니다."));
    }

    private Comment getComment(Long scheduleId, Long commentId) {
        return commentRepository.findByCommentIdAndScheduleScheduleId(commentId, scheduleId)
                .orElseThrow(() -> new NotFoundException("코멘트가 존재하지 않습니다."));
    }
}
