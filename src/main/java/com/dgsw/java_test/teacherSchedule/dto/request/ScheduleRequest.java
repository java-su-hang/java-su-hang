package com.dgsw.java_test.teacherSchedule.dto.request;

import com.dgsw.java_test.teacherSchedule.entity.Subject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleRequest {
    @NotNull
    private Subject subject;

    @NotNull
    private LocalDateTime date;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private boolean completed;
}
