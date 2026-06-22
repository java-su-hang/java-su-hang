package com.dgsw.java_test.controller;

import com.dgsw.java_test.dto.GetCommentsResponse;
import com.dgsw.java_test.entity.Comment;
import com.dgsw.java_test.entity.CommentCategory;
import com.dgsw.java_test.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{scheduleId}/comments")
    public ResponseEntity<GetCommentsResponse> getComments(
        @PathVariable("scheduleId") Long scheduleId,
        @Param("category") CommentCategory commentCategory
    ) {
        GetCommentsResponse res = new GetCommentsResponse(
            commentService.getComments(
                scheduleId,
                commentCategory
            )
        );

        return ResponseEntity.ok(res);
    }
}
