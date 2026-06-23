package com.dgsw.java_test.service;

import com.dgsw.java_test.dto.request.ScheduleRequest;
import com.dgsw.java_test.dto.response.ScheduleResponse;

public interface TeacherScheduleService {
    ScheduleResponse createSchedule(ScheduleRequest request);

    ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest request);

    void deleteSchedule(Long scheduleId);
}
