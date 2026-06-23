package com.dgsw.java_test.dto.request;

import com.dgsw.java_test.entity.CommentCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCommentRequest(
        @NotNull CommentCategory category,
        @NotBlank @Size(max = 1000) String content,
        @NotBlank @Size(max = 50) String author
) {
}
