package com.dgsw.java_test.dto.response;

import com.dgsw.java_test.entity.Favorite;
import com.dgsw.java_test.entity.Schedule;

public record FavoriteResponse(
        Long id,
        Long scheduleId,
        String title,
        String content
) {

    public static FavoriteResponse from(Favorite favorite) {
        Schedule schedule = favorite.getSchedule();

        return new FavoriteResponse(
                favorite.getId(),
                schedule.getScheduleId(),
                schedule.getTitle(),
                schedule.getContent()
        );
    }
}
