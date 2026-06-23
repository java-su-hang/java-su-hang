package com.dgsw.java_test.dto.request;

import com.dgsw.java_test.entity.CommentCategory;
import jakarta.validation.constraints.Size;

public record UpdateCommentRequest(
        @Size(max = 1000) String content,
        CommentCategory category
) {
}
