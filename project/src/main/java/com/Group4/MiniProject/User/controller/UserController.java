package com.Group4.MiniProject.User.controller;

import com.Group4.MiniProject.User.dto.UserDeleteRequestDto;
import com.Group4.MiniProject.User.dto.UserRequestDto;
import com.Group4.MiniProject.User.dto.UserResponseDto;
import com.Group4.MiniProject.User.dto.LoginResponseDto;
import com.Group4.MiniProject.common.dto.ErrorResponseDto;
import com.Group4.MiniProject.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * @param requestDto 닉네임과 비밀번호를 담은 요청 객체
     * @return 성공 시 "ok", 실패 시 에러 메시지
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserRequestDto requestDto) {
        try {
            userService.signup(requestDto);

            return ResponseEntity.ok(UserResponseDto.ok());

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponseDto(e.getMessage()));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponseDto("서버 에러가 발생했습니다."));
        }
    }

    /**
     * @param requestDto 닉네임과 비밀번호를 담은 요청 객체
     * @return 성공 시 사용자 정보, 실패 시 에러 메시지
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDto requestDto) {
        try {
            String nickname = userService.login(requestDto);

            return ResponseEntity.ok(LoginResponseDto.success(nickname));

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponseDto(e.getMessage()));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponseDto("서버 에러 발생."));
        }
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody UserDeleteRequestDto requestDto) {
        try {
            userService.deleteUser(requestDto);
            return ResponseEntity.ok(UserDeleteRequestDto.ok());
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponseDto(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponseDto("서버 에러 발생."));
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API 서버가 정상 작동 중입니다.");
    }
}
