package com.dgsw.java_test.dto.response;

import com.dgsw.java_test.entity.Comment;
import com.dgsw.java_test.entity.CommentCategory;
import java.time.Instant;

public record CommentResponse(
        Long commentId,
        CommentCategory category,
        String content,
        String author,
        Long scheduleId,
        Instant createdAt,
        Instant updatedAt
) {

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getCommentId(),
                comment.getCategory(),
                comment.getContent(),
                comment.getAuthor(),
                comment.getScheduleId(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}
