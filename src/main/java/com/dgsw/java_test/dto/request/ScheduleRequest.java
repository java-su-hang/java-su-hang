package com.dgsw.java_test.dto.request;

import lombok.Getter;
import java.time.LocalDate;

@Getter
public class ScheduleRequest {
    private String subject;
    private LocalDate date;
    private String title;
    private String content;
}