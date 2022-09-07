package com.example.blv_chat.repository;

import com.example.blv_chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findMessageByAuthor(String str);

}
