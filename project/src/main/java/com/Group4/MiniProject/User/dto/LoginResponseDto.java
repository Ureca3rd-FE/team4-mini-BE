package com.Group4.MiniProject.User.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class LoginResponseDto {
    private String message;
    private String nickname;

    public static LoginResponseDto success(String nickname) {
        return new LoginResponseDto("로그인 성공", nickname);
    }
}