package com.example.blv_chat.controller;


import com.example.blv_chat.model.Message;
import com.example.blv_chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessage(@RequestParam(required = false) String author){
        try
        {
            List<Message> message = new ArrayList<Message>();
            if (author == null)
                messageRepository.findAll().forEach(message::add);
            else
                messageRepository.findMessageByAuthor(author).forEach(message::add);
            if (message.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
