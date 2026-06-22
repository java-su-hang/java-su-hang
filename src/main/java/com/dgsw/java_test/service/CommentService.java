package com.dgsw.java_test.service;

import com.dgsw.java_test.dto.GetCommentsResponse;
import com.dgsw.java_test.entity.Comment;
import com.dgsw.java_test.entity.CommentCategory;
import com.dgsw.java_test.repository.CommentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getComments(Long scheduleId,  CommentCategory commentCategory) {
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
}
