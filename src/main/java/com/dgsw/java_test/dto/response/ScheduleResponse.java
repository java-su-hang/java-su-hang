package com.dgsw.java_test.dto.response;

import com.dgsw.java_test.entity.Schedule;
import com.dgsw.java_test.entity.Subject;
import java.time.LocalDateTime;

public record ScheduleResponse(
        Long scheduleId,
        Subject subject,
        LocalDateTime date,
        String title,
        String content,
        boolean completed
) {

    public static ScheduleResponse from(Schedule schedule) {
        return new ScheduleResponse(
                schedule.getScheduleId(),
                schedule.getSubject(),
                schedule.getDate(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.isCompleted()
        );
    }
}
