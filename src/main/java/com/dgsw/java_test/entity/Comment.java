package com.dgsw.java_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@Setter
@Builder
@Table(name="COMMENT")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long commentId;

    @Enumerated(EnumType.STRING)
    public CommentCategory category;

    public String content;

    public String author;

    @ManyToOne
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    public Schedule schedule;

    @Column(name = "schedule_id")
    private Long scheduleId;

    @CreatedDate
    public Instant createdAt;

    @LastModifiedDate
    public Instant updatedAt;
}
