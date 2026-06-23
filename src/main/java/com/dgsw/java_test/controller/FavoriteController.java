package com.dgsw.java_test.controller;

import com.dgsw.java_test.dto.request.ScheduleRequest;
import com.dgsw.java_test.dto.response.FavoriteResponse;
import com.dgsw.java_test.dto.response.ScheduleResponse;
import com.dgsw.java_test.service.FavoriteService;
import com.dgsw.java_test.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FavoriteController {

    private final ScheduleService scheduleService;
    private final FavoriteService favoriteService;

    // 일정 조회
    // 애매해서 일단 냅둠
    @GetMapping("/schedules")
    public List<ScheduleResponse> getSchedules() {
        return scheduleService.getAllSchedules();
    }

    // 즐겨찾기 추가
    @PostMapping("/favorites/{scheduleId}")
    public void addFavorite(@PathVariable Long scheduleId) {
        favoriteService.addFavorite(scheduleId);
    }

    // 즐겨찾기 조회
    @GetMapping("/favorites")
    public List<FavoriteResponse> getFavorites() {
        return favoriteService.getAllFavorites();
    }

    // 즐겨찾기 삭제
    @DeleteMapping("/favorites/{scheduleId}")
    public void deleteFavorite(@PathVariable Long scheduleId) {
        favoriteService.deleteFavorite(scheduleId);
    }
}