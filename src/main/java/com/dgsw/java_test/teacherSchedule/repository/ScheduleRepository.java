package com.dgsw.java_test.teacherSchedule.repository;

import com.dgsw.java_test.teacherSchedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
