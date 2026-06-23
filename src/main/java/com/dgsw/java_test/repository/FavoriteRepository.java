package com.dgsw.java_test.repository;

import com.dgsw.java_test.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Optional<Favorite> findByScheduleId(Long scheduleId);

    boolean existsByScheduleId(Long scheduleId);
}