package com.dgsw.java_test.service;

import com.dgsw.java_test.common.exception.NotFoundException;
import com.dgsw.java_test.dto.request.ScheduleRequest;
import com.dgsw.java_test.dto.response.ScheduleResponse;
import com.dgsw.java_test.entity.Schedule;
import com.dgsw.java_test.repository.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleResponse> getSchedules() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponse::from)
                .toList();
    }

    @Transactional
    public ScheduleResponse createSchedule(ScheduleRequest request) {
        Schedule schedule = Schedule.create(
                request.subject(),
                request.date(),
                request.title(),
                request.content(),
                request.completed()
        );

        return ScheduleResponse.from(scheduleRepository.save(schedule));
    }

    @Transactional
    public ScheduleResponse updateSchedule(Long scheduleId, ScheduleRequest request) {
        Schedule schedule = getSchedule(scheduleId);

        schedule.update(
                request.subject(),
                request.date(),
                request.title(),
                request.content(),
                request.completed()
        );

        return ScheduleResponse.from(schedule);
    }

    @Transactional
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.delete(getSchedule(scheduleId));
    }

    private Schedule getSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NotFoundException("일정이 존재하지 않습니다."));
    }
}
