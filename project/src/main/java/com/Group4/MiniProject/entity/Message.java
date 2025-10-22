package com.Group4.MiniProject.entity;

import jakarta.persistence.*;
import lombok.*;

// --- UUID 관련 import는 모두 삭제 ---

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "message")
public class Message {

    /**
     * 'index' (자동 증가 숫자) 형태의 ID를 사용합니다.
     * DB 컬럼명은 ERD에 맞게 "message_id"로 지정합니다.
     */
    @Id
    @GeneratedValue
    @JoinColumn(name = "message_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "received_user_id")
    private User receivedUser;

    @Column(length = 500)
    private String message;

    @Column(name = "is_open") // ERD 및 DB 표준에 맞게 'is_open'으로 지정
    private boolean isOpen;

    // 닉네임 글자수 제한 없음
    @Column(length = 100)
    private String nickname;
}