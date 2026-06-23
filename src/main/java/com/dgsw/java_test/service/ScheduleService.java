package com.dgsw.java_test.service;

import com.dgsw.java_test.dto.request.ScheduleRequest;
import com.dgsw.java_test.dto.response.ScheduleResponse;
import com.dgsw.java_test.entity.Schedule;
import com.dgsw.java_test.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 일정 전체 조회
    public List<ScheduleResponse> getAllSchedules() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponse::new)
                .toList();
    }
}