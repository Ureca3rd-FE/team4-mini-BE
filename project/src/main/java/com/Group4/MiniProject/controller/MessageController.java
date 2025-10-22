package com.Group4.MiniProject.controller;

import com.Group4.MiniProject.dto.MessageRequestDto;
import com.Group4.MiniProject.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    /**
     * 메시지 작성 API (테스트용 임시 버전)
     * - @Valid: DTO의 유효성 검증(@Size, @NotEmpty)을 실행합니다.
     * - @RequestBody: JSON 데이터를 DTO로 변환합니다.
     */
    @PostMapping
    public ResponseEntity<String> createMessage(@Valid @RequestBody MessageRequestDto requestDto) {

        // Security 적용 전에는 임시로 requestDto에서 보낸 사람 닉네임을 가져옵니다.
        String senderNickname = requestDto.getSenderNickname();

        // 실제 서비스에서는 SecurityContext에서 인증된 사용자의 닉네임을 가져와야 합니다.
        messageService.createMessage(requestDto, senderNickname);

        return ResponseEntity.ok("ok");
    }
}

