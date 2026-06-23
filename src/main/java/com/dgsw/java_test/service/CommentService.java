package com.dgsw.java_test.service;

import com.dgsw.java_test.dto.GetCommentsResponse;
import com.dgsw.java_test.entity.Comment;
import com.dgsw.java_test.entity.CommentCategory;
import com.dgsw.java_test.repository.CommentRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments(
        Long scheduleId,
        CommentCategory commentCategory
    ) {
        List<Comment> comments;
        // commentCategory를 지정한 경우 해당 category만을 검색
        if(commentCategory != null) {
            comments = commentRepository.findAllByScheduleIdAndCategory(scheduleId, commentCategory);
        } else {
            // commentCategory가 null인 경우 category는 신경X
            comments = commentRepository.findAllByScheduleId(scheduleId);
        }
        return comments;
    }

    @Transactional
    public boolean createComment(
        CommentCategory commentCategory,
        String content,
        String author,
        Long scheduleId
    ) {
        Comment comment = Comment.builder()
            .content(content)
            .author(author)
            .scheduleId(scheduleId)
            .category(commentCategory)
            .build();

        commentRepository.save(comment);
        return true;
    }

    @Transactional
    public boolean updateComment(
        Long commentId,
        String content,
        CommentCategory category
    ) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if(commentOptional.isEmpty()) {
            return false;
        }
        Comment comment = commentOptional.get();

        if(category != null) {
            comment.setCategory(category);
        }
        if(content != null) {
            comment.setContent(content);
        }

        commentRepository.save(comment);

        return true;
    }

    @Transactional
    public boolean deleteComment(
        Long commentId
    ) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);

        if(commentOptional.isEmpty()) {
            return false;
        }

        Comment comment = commentOptional.get();
        commentRepository.delete(comment);

        return true;
    }
}
