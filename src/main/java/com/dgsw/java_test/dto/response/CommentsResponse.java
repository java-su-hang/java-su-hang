package com.dgsw.java_test.dto.response;

import com.dgsw.java_test.entity.Comment;
import java.util.List;

public record CommentsResponse(
        List<CommentResponse> comments
) {

    public static CommentsResponse from(List<Comment> comments) {
        return new CommentsResponse(
                comments.stream()
                        .map(CommentResponse::from)
                        .toList()
        );
    }
}
