package com.Group4.MiniProject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageRequestDto {

    private Long themeId;

    /**
     * '요청 바디 검증' (Validation) 기능을 위해 추가
     */
    @NotEmpty(message = "메시지 내용은 비어 있을 수 없습니다.")
    @Size(min = 1, max = 500, message = "메시지는 1자 이상 500자 이하로 작성해야 합니다.")
    private String message;

    // 받는 사람 닉네임
    private String receivedNickname;

    // 보내는 사름 닉네임
    private String senderNickname;
}
