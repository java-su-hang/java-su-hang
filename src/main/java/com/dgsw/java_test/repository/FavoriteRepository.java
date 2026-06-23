package com.dgsw.java_test.repository;

import com.dgsw.java_test.entity.Favorite;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Optional<Favorite> findByScheduleScheduleId(Long scheduleId);

    boolean existsByScheduleScheduleId(Long scheduleId);
}
