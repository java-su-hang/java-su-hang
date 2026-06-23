package com.dgsw.java_test.dto.response;

import com.dgsw.java_test.entity.Favorite;
import lombok.Getter;

@Getter
public class FavoriteResponse {

    private Long id;
    private Long scheduleId;
    private String title;
    private String content;

    public FavoriteResponse(Favorite favorite) {
        this.id = favorite.getId();
        this.scheduleId = favorite.getSchedule().getId();
        this.title = favorite.getSchedule().getTitle();
        this.content = favorite.getSchedule().getContent();
    }
}