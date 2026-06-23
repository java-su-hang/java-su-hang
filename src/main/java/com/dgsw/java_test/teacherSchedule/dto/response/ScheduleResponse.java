package com.dgsw.java_test.teacherSchedule.dto.response;

import com.dgsw.java_test.teacherSchedule.entity.Schedule;
import com.dgsw.java_test.teacherSchedule.entity.Subject;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ScheduleResponse {
    private Long scheduleId;
    private Subject subject;
    private LocalDateTime date;
    private String title;
    private String content;
    private boolean completed;

    public static ScheduleResponse from(Schedule schedule) {
        return ScheduleResponse.builder()
                .scheduleId(schedule.getScheduleId())
                .subject(schedule.getSubject())
                .date(schedule.getDate())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .completed(schedule.isCompleted())
                .build();
    }
}
