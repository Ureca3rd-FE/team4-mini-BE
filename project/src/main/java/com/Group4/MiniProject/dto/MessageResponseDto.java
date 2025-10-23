package com.Group4.MiniProject.dto;

import com.Group4.MiniProject.entity.Message;
import com.Group4.MiniProject.entity.User;
import lombok.Getter;
import java.util.UUID;

@Getter
public class MessageResponseDto {
    /**
     * 컴파일 에러를 해결하기 위해
     * 타입을 UUID에서 Long으로 수정했습니다.
     */

    private UUID uuid; // UUID  칼럼 추가

    private Long id; // private UUID id; -> private Long id;

    private User receivedUser;

    private String message;

    private String nickname;

    private Long themeId;

    private boolean isOpen;

    public MessageResponseDto(Message message) {
        this.id = message.getId();
        this.uuid = message.getUuid(); // UUID 칼럼 추가
        this.receivedUser = message.getReceivedUser();
        this.message = message.getMessage();
        this.nickname = message.getNickname();
        this.themeId = message.getTheme().getThemeId();
        this.isOpen = message.isOpen();
    }
}
