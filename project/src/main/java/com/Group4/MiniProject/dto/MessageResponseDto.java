package com.Group4.MiniProject.dto;

import com.Group4.MiniProject.entity.Message;
import com.Group4.MiniProject.entity.User;
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
