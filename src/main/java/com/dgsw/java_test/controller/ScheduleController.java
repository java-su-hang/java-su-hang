package com.dgsw.java_test.controller;

import com.dgsw.java_test.dto.request.ScheduleRequest;
import com.dgsw.java_test.dto.response.ScheduleResponse;
import com.dgsw.java_test.service.TeacherScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {
    private final TeacherScheduleService teacherScheduleService;


    @PostMapping
    public ScheduleResponse createSchedule(@RequestBody @Valid ScheduleRequest request) {
        return teacherScheduleService.createSchedule(request);
    }

    @PutMapping("/{scheduleId}")
    public ScheduleResponse updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody @Valid ScheduleRequest request
    ) {
        return teacherScheduleService.updateSchedule(scheduleId, request);
    }

    @DeleteMapping("/{scheduleId}")
    public void deleteSchedule(@PathVariable Long scheduleId) {
        teacherScheduleService.deleteSchedule(scheduleId);
    }
}
