package com.dgsw.java_test.dto.response;

import com.dgsw.java_test.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleResponse {

    private Long id;
    private String subject;
    private LocalDate date;
    private String title;
    private String content;
    private boolean completed;

    public ScheduleResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.subject = schedule.getSubject();
        this.date = schedule.getDate();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.completed = schedule.isCompleted();
    }
}