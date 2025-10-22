package com.Group4.MiniProject.repository;

import com.Group4.MiniProject.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    List<Message> findByReceivedUserId(Long userId);
    
    // 메세지 내용 확인
    Optional<Message> findByIdAndReceivedUserId(UUID id, Long userId);
}

