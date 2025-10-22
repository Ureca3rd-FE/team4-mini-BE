package com.Group4.MiniProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDeleteResponseDto {
    private String message;

    public static UserDeleteResponseDto ok() {
        return new UserDeleteResponseDto("사용자가 삭제되었습니다.");
    }
}