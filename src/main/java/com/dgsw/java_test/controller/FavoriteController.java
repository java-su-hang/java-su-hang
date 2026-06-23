package com.dgsw.java_test.controller;

import com.dgsw.java_test.dto.response.FavoriteResponse;
import com.dgsw.java_test.service.FavoriteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/{scheduleId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFavorite(@PathVariable Long scheduleId) {
        favoriteService.addFavorite(scheduleId);
    }

    @GetMapping
    public List<FavoriteResponse> getFavorites() {
        return favoriteService.getAllFavorites();
    }

    @DeleteMapping("/{scheduleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFavorite(@PathVariable Long scheduleId) {
        favoriteService.deleteFavorite(scheduleId);
    }
}
