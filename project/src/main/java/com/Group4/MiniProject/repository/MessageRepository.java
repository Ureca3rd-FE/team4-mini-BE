package com.Group4.MiniProject.repository;

import com.Group4.MiniProject.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
    List<Message> findByReceivedUserId(Long userId);
    
    // 메세지 개별 조회
//    Optional<Message> findByIdAndReceiverId(UUID id, UUID receiverId);
}

