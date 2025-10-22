package com.Group4.MiniProject.service;

import com.Group4.MiniProject.dto.UserRequestDto;
import com.Group4.MiniProject.entity.User;
import com.Group4.MiniProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signup(UserRequestDto requestDto) {
        if (requestDto.getNickname() == null || requestDto.getNickname().trim().isEmpty()) {
            throw new IllegalArgumentException("닉네임을 입력해주세요.");
        }
        if (requestDto.getPassword() == null || requestDto.getPassword().length() > 4) {
            throw new IllegalArgumentException("비밀번호는 4자리 이하여야 합니다.");
        }
        if (!requestDto.getPassword().matches("\\d{4}")) {
            throw new IllegalArgumentException("비밀번호는 숫자 4자리로 구성되어야 합니다.");
        }
        if(userRepository.existsByNickname(requestDto.getNickname())) {
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        }

        User user = User.builder()
                .nickname(requestDto.getNickname())
                .password(requestDto.getPassword())
                .build();
        userRepository.save(user);
    }

}