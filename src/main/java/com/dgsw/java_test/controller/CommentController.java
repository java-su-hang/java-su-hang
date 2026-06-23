package com.dgsw.java_test.controller;

import com.dgsw.java_test.dto.request.CreateCommentRequest;
import com.dgsw.java_test.dto.request.UpdateCommentRequest;
import com.dgsw.java_test.dto.response.CommentResponse;
import com.dgsw.java_test.dto.response.CommentsResponse;
import com.dgsw.java_test.entity.CommentCategory;
import com.dgsw.java_test.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules/{scheduleId}/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public CommentsResponse getComments(
            @PathVariable Long scheduleId,
            @RequestParam(required = false) CommentCategory category
    ) {
        return commentService.getComments(scheduleId, category);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse createComment(
            @PathVariable Long scheduleId,
            @RequestBody @Valid CreateCommentRequest request
    ) {
        return commentService.createComment(scheduleId, request);
    }

    @PatchMapping("/{commentId}")
    public CommentResponse updateComment(
            @PathVariable Long scheduleId,
            @PathVariable Long commentId,
            @RequestBody @Valid UpdateCommentRequest request
    ) {
        return commentService.updateComment(scheduleId, commentId, request);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(
            @PathVariable Long scheduleId,
            @PathVariable Long commentId
    ) {
        commentService.deleteComment(scheduleId, commentId);
    }
}
