package com.Group4.MiniProject.controller;

import com.Group4.MiniProject.dto.ThemeResponseDto;
import com.Group4.MiniProject.entity.Theme;
import com.Group4.MiniProject.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/themes")
@RequiredArgsConstructor
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping
    public ResponseEntity<List<ThemeResponseDto>> getAllThemes() {
        List<ThemeResponseDto> themes = themeService.getAllThemes();

        return ResponseEntity.ok(themes);
    }
}