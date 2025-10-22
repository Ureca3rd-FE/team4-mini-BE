package com.Group4.MiniProject.dto;

import com.Group4.MiniProject.entity.Theme;
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