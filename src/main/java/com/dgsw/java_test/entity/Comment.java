package com.dgsw.java_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CommentCategory category;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false, length = 50)
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    private Comment(
            CommentCategory category,
            String content,
            String author,
            Schedule schedule
    ) {
        this.category = category;
        this.content = content;
        this.author = author;
        this.schedule = schedule;
    }

    public static Comment create(
            CommentCategory category,
            String content,
            String author,
            Schedule schedule
    ) {
        return new Comment(category, content, author, schedule);
    }

    public void update(CommentCategory category, String content) {
        if (category != null) {
            this.category = category;
        }

        if (content != null) {
            this.content = content;
        }
    }

    public Long getScheduleId() {
        return schedule.getScheduleId();
    }
}
