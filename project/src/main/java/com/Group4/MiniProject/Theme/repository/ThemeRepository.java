package com.Group4.MiniProject.Theme.repository;

import com.Group4.MiniProject.Theme.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}