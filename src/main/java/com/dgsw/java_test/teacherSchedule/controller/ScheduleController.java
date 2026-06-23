package com.dgsw.java_test.teacherSchedule.controller;

import com.dgsw.java_test.teacherSchedule.dto.request.ScheduleRequest;
import com.dgsw.java_test.teacherSchedule.dto.response.ScheduleResponse;
import com.dgsw.java_test.teacherSchedule.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;


    @PostMapping
    public ScheduleResponse createSchedule(@RequestBody @Valid ScheduleRequest request) {
        return scheduleService.createSchedule(request);
    }

    @PutMapping("/{scheduleId}")
    public ScheduleResponse updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody @Valid ScheduleRequest request
    ) {
        return scheduleService.updateSchedule(scheduleId, request);
    }

    @DeleteMapping
    public void deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
    }
}
