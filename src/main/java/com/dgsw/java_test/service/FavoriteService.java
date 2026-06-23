package com.dgsw.java_test.service;

import com.dgsw.java_test.common.exception.ConflictException;
import com.dgsw.java_test.common.exception.NotFoundException;
import com.dgsw.java_test.dto.response.FavoriteResponse;
import com.dgsw.java_test.entity.Favorite;
import com.dgsw.java_test.entity.Schedule;
import com.dgsw.java_test.repository.FavoriteRepository;
import com.dgsw.java_test.repository.ScheduleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void addFavorite(Long scheduleId) {
        if (favoriteRepository.existsByScheduleScheduleId(scheduleId)) {
            throw new ConflictException("이미 즐겨찾기에 추가된 일정입니다.");
        }

        favoriteRepository.save(Favorite.create(getSchedule(scheduleId)));
    }

    public List<FavoriteResponse> getAllFavorites() {
        return favoriteRepository.findAll()
                .stream()
                .map(FavoriteResponse::from)
                .toList();
    }

    @Transactional
    public void deleteFavorite(Long scheduleId) {
        Favorite favorite = favoriteRepository.findByScheduleScheduleId(scheduleId)
                .orElseThrow(() -> new NotFoundException("즐겨찾기가 존재하지 않습니다."));

        favoriteRepository.delete(favorite);
    }

    private Schedule getSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NotFoundException("일정이 존재하지 않습니다."));
    }
}
