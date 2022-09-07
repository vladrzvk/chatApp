package com.example.blv_chat.repository;

import com.example.blv_chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {

    Optional<Message> findMessageByAuthor(String str);
    List<Message> findMessageByContent(String content);
    List<Message> findMessageById(Long id);

    Message deleteMessageById(Long id);
}
