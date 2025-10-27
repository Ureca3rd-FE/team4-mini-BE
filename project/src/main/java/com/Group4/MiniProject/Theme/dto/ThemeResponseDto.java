package com.Group4.MiniProject.Theme.dto;

import com.Group4.MiniProject.Theme.entity.Theme;
import lombok.Getter;

@Getter
public class ThemeResponseDto {
    private Long themeId;
    private String name;
    private String imgUrl;

    public ThemeResponseDto(Theme theme) {
        this.themeId = theme.getThemeId();
        this.name = theme.getName();
        this.imgUrl = theme.getImgUrl();
    }
}