package com.dgsw.java_test.dto;

import com.dgsw.java_test.entity.Comment;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCommentsResponse {
    public List<Comment> comments;
}
