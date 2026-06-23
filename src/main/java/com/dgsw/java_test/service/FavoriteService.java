package com.dgsw.java_test.service;

import com.dgsw.java_test.dto.response.FavoriteResponse;
import com.dgsw.java_test.entity.Favorite;
import com.dgsw.java_test.entity.Schedule;
import com.dgsw.java_test.repository.FavoriteRepository;
import com.dgsw.java_test.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final ScheduleRepository scheduleRepository;

    // 즐겨찾기 추가
    public void addFavorite(Long scheduleId) {

        if (favoriteRepository.existsByScheduleId(scheduleId)) {
            throw new IllegalArgumentException("이미 즐겨찾기에 추가된 일정입니다.");
        }

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정 없음"));

        Favorite favorite = new Favorite();
        favorite.setSchedule(schedule);

        favoriteRepository.save(favorite);
    }

    // 즐겨찾기 전체 조회
    public List<FavoriteResponse> getAllFavorites() {

        return favoriteRepository.findAll()
                .stream()
                .map(FavoriteResponse::new)
                .toList();
    }

    // 즐겨찾기 삭제
    public void deleteFavorite(Long scheduleId) {

        Favorite favorite = favoriteRepository.findByScheduleId(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("즐겨찾기 없음"));

        favoriteRepository.delete(favorite);
    }
}