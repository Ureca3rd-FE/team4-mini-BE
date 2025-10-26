package com.Group4.MiniProject.User.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDeleteRequestDto {
    private String nickname;
    private String password;
}