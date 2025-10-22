package com.Group4.MiniProject.service;

import com.Group4.MiniProject.entity.Theme;
import com.Group4.MiniProject.dto.ThemeResponseDto;
import com.Group4.MiniProject.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThemeService {

    private final ThemeRepository themeRepository;

    public List<ThemeResponseDto> getAllThemes() {
        List<Theme> themes = themeRepository.findAll();

        return themes.stream().map(ThemeResponseDto::new).collect(Collectors.toList());
    }
}