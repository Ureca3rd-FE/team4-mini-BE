package com.Group4.MiniProject.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private String message;

    public static UserResponseDto Ok() {
        return new UserResponseDto("Ok");
    }
}