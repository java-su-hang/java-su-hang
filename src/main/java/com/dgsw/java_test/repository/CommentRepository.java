package com.dgsw.java_test.repository;

import com.dgsw.java_test.entity.Comment;
import com.dgsw.java_test.entity.CommentCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByScheduleId(Long scheduleId);

    List<Comment> findAllByScheduleIdAndCategory(Long scheduleId, CommentCategory category);
}
