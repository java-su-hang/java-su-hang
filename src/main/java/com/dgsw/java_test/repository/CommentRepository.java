package com.dgsw.java_test.repository;

import com.dgsw.java_test.entity.Comment;
import com.dgsw.java_test.entity.CommentCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByScheduleScheduleId(Long scheduleId);

    List<Comment> findAllByScheduleScheduleIdAndCategory(Long scheduleId, CommentCategory category);

    Optional<Comment> findByCommentIdAndScheduleScheduleId(Long commentId, Long scheduleId);
}
