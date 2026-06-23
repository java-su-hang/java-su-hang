package com.dgsw.java_test.teacherSchedule.service.impl;

import com.dgsw.java_test.teacherSchedule.dto.request.ScheduleRequest;
import com.dgsw.java_test.teacherSchedule.dto.response.ScheduleResponse;
import com.dgsw.java_test.teacherSchedule.entity.Schedule;
import com.dgsw.java_test.teacherSchedule.repository.ScheduleRepository;
import com.dgsw.java_test.teacherSchedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    @Transactional
    public ScheduleResponse createSchedule(ScheduleRequest request) {
        Schedule schedule = Schedule.builder()
                .subject(request.getSubject())
                .date(request.getDate())
                .title(request.getTitle())
                .content(request.getContent())
                .completed(request.isCompleted())
                .build();

        scheduleRepository.save(schedule);
        return ScheduleResponse.from(schedule);
    }

    @Override
    @Transactional
    public ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        schedule.setSubject(request.getSubject());
        schedule.setDate(request.getDate());
        schedule.setTitle(request.getTitle());
        schedule.setContent(request.getContent());
        schedule.setCompleted(request.isCompleted());

        return ScheduleResponse.from(schedule);
    }

    @Override
    @Transactional
    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        scheduleRepository.save(schedule);
    }
}
