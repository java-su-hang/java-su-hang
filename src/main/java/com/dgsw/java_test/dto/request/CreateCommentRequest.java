package com.dgsw.java_test.dto.request;

import com.dgsw.java_test.entity.CommentCategory;

public class CreateCommentRequest {
    public CommentCategory category;
    public String content;
    public String author;
}
