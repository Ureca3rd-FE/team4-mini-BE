package com.Group4.MiniProject.Message.dto;

import com.Group4.MiniProject.Message.entity.Message;
import com.Group4.MiniProject.User.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseDto {
    private Long longId;
    private UUID uuid;
    private String message;
    private String nickname;
    private Long themeId;
    private boolean isOpen;

    // 받은 사람 정보는 순환 참조를 피하기 위해 일부 속성을 무시합니다. (순환 참조를 하게 되면 무한 루프에 빠집니다.)
    // 무한 루프 방지
    @JsonIgnoreProperties({"receivedMessages", "ingredient"})
    private User receivedUser;

    public MessageResponseDto(Message message) {
        this.longId = message.getId();
        this.uuid = message.getUuid();
        this.receivedUser = message.getReceivedUser();
        this.message = message.getMessage();
        this.nickname = message.getNickname();
        this.themeId = message.getTheme().getThemeId();
        this.isOpen = message.isOpen();
    }
}