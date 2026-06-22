package com.dgsw.java_test.teacherSchedule.service;

import com.dgsw.java_test.teacherSchedule.dto.request.ScheduleRequest;
import com.dgsw.java_test.teacherSchedule.dto.response.ScheduleResponse;

public interface ScheduleService {
    ScheduleResponse createSchedule(ScheduleRequest request);


}
