package com.dgsw.java_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject", nullable = false)
    private Subject subject;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @Column(name = "content", nullable = false, length = 300)
    private String content;

    @Column(name = "completed", nullable = false)
    private boolean completed = false;

    private Schedule(
            Subject subject,
            LocalDateTime date,
            String title,
            String content,
            boolean completed
    ) {
        this.subject = subject;
        this.date = date;
        this.title = title;
        this.content = content;
        this.completed = completed;
    }

    public static Schedule create(
            Subject subject,
            LocalDateTime date,
            String title,
            String content,
            boolean completed
    ) {
        return new Schedule(subject, date, title, content, completed);
    }

    public void update(
            Subject subject,
            LocalDateTime date,
            String title,
            String content,
            boolean completed
    ) {
        this.subject = subject;
        this.date = date;
        this.title = title;
        this.content = content;
        this.completed = completed;
    }
}
