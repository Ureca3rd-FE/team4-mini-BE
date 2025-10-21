package com.Group4.MiniProject.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "received_user_id")
    private User receivedUser;

    @Column(length = 500)
    private String message;

    private boolean isOpen;

    @Column(length = 5)
    private String nickname;
}