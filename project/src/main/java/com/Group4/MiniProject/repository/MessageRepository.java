package com.Group4.MiniProject.repository;

import com.Group4.MiniProject.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
// import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, Long> { // UUID -> Long으로 수정
    List<Message> findByReceivedUserId(Long userId);
}

