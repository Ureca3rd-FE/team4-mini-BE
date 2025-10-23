package com.Group4.MiniProject.Message.controller;

import com.Group4.MiniProject.Message.dto.MessageRequestDto;
import com.Group4.MiniProject.Message.dto.MessageResponseDto;
import com.Group4.MiniProject.Message.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    // 메시지 작성 API
    @PostMapping
    public ResponseEntity<String> createMessage(@Valid @RequestBody MessageRequestDto requestDto) {
        String senderNickname = requestDto.getSenderNickname();
        messageService.createMessage(requestDto, senderNickname);
        return ResponseEntity.ok("ok");
    }

    // 메시지 개별 조회
    @GetMapping("/{messageId}")
    public ResponseEntity<MessageResponseDto> getMessageDetail(@PathVariable UUID messageId) {
        MessageResponseDto message = messageService.getMessageDetail(messageId);
        return ResponseEntity.ok(message);
    }  
}
