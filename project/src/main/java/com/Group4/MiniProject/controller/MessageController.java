package com.Group4.MiniProject.controller;

import com.Group4.MiniProject.dto.MessageResponseDto;
import com.Group4.MiniProject.service.MessageService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/messageDetail")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    // 메세지 개별 조회
    @GetMapping("/{messageId}")
    public ResponseEntity<MessageResponseDto> getMessageDetail(@PathVariable UUID messageId) {
        MessageResponseDto message = messageService.getMessageDetail(messageId);
        return ResponseEntity.ok(message);
    }  
}
