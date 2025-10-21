package com.Group4.MiniProject.service;

import com.Group4.MiniProject.dto.UserRequestDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void signup(UserRequestDto requestDto) {
        if (requestDto.getNickname() == null || requestDto.getNickname().trim().isEmpty()) {
            throw new IllegalArgumentException("닉네임을 입력해주세요.");
        }
        if (requestDto.getPassword() == null || requestDto.getPassword().length() < 4) {
            throw new IllegalArgumentException("비밀번호는 최소 4자 이상이어야 합니다.");
        }
        if (!requestDto.getPassword().matches("\\d{4}")) {
            throw new IllegalArgumentException("비밀번호는 숫자 4자리로 구성되어야 합니다.");
        }
        // TODO: 실제 회원가입 로직 구현
    }
}