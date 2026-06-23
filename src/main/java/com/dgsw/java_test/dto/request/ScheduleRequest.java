package com.dgsw.java_test.dto.request;

import com.dgsw.java_test.entity.Subject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record ScheduleRequest(
        @NotNull Subject subject,
        @NotNull LocalDateTime date,
        @NotBlank @Size(max = 30) String title,
        @NotBlank @Size(max = 300) String content,
        @NotNull Boolean completed
) {
}
