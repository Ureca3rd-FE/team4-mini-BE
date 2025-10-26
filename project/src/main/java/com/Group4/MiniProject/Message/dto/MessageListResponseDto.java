package com.Group4.MiniProject.Message.dto;

import com.Group4.MiniProject.Message.entity.Message;
import com.Group4.MiniProject.Theme.entity.Theme;
import lombok.Getter;

import java.util.UUID;

@Getter
public class MessageListResponseDto {
    private UUID uuid;
    private Long themeId;
    private String nickname;

    public MessageListResponseDto(Message message) {
        this.uuid = message.getUuid();
        this.themeId = message.getTheme().getThemeId();
        this.nickname = message.getNickname();
    }
}