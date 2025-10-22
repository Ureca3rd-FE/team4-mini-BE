package com.Group4.MiniProject.service;

import com.Group4.MiniProject.dto.MessageResponseDto;
import com.Group4.MiniProject.entity.Message;
import com.Group4.MiniProject.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;



 // 메세지 개별 조회
    public MessageResponseDto getMessageDetail(UUID messageId) {
        Message message = messageRepository.findById(messageId)
        		.orElseThrow(() -> new ResponseStatusException(
        			    HttpStatus.NOT_FOUND, "해당 메시지를 찾을 수 없습니다."
        			));

        return MessageResponseDto.builder()
                .id(message.getId())
                .content(message.getMessage()) // 엔티티의 message 필드
                .sender(message.getNickname()) // nickname = 보낸 사람
                .build();
    }
}
