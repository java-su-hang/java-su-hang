package com.dgsw.java_test.controller;

import com.dgsw.java_test.dto.request.CreateCommentRequest;
import com.dgsw.java_test.dto.response.GetCommentsResponse;
import com.dgsw.java_test.dto.request.UpdateCommentRequest;
import com.dgsw.java_test.entity.CommentCategory;
import com.dgsw.java_test.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/{scheduleId}/comments")
    public ResponseEntity<String> createComment(
        @PathVariable("scheduleId") Long scheduleId,
        @RequestBody CreateCommentRequest createCommentRequest
    ) {
        boolean created = commentService.createComment(
            createCommentRequest.category,
            createCommentRequest.content,
            createCommentRequest.author,
            scheduleId
        );

        if(!created){
            return ResponseEntity.internalServerError().body("서버 오류 발생");
        }
        return ResponseEntity.ok("성공적으로 코멘트를 생성했습니다.");
    }

    @PatchMapping("/{scheduleId}/comments/{commentId}")
    public ResponseEntity<String> updateComment(
        @PathVariable("commentId") Long commentId,
        @RequestBody UpdateCommentRequest updateCommentRequest
    ) {
        boolean updated = commentService.updateComment(
            commentId,
            updateCommentRequest.content,
            updateCommentRequest.category
        );

        if(!updated) {
            return ResponseEntity.internalServerError().body("서버 오류 발생");
        }
        return ResponseEntity.ok("성공적으로 코멘트가 수정됐습니다.");
    }

    @DeleteMapping("/{scheduleId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(
        @PathVariable("commentId") Long commentId
    ) {
        boolean deleted = commentService.deleteComment(commentId);

        if(!deleted) {
            return ResponseEntity.internalServerError().body("서버 오류 발생");
        }
        return ResponseEntity.ok("성공적으로 코멘트를 삭제했습니다.");
    }
}
