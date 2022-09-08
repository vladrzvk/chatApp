package com.example.blv_chat.controller;


import com.example.blv_chat.model.Message;
import com.example.blv_chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.blv_chat.service.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageService messageService;

    //    create
    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        return messageService.serviceCreateMessage(message);
    }

    //    request
    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessage(@RequestParam(required = false) String content) {
        return messageService.serviceGetAllMessage(content);
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id) {
        return messageService.serviceGetMessageById(id);
    }

    @GetMapping("/messages/{author}")
    public ResponseEntity<Message> getMessageByAuthor(@PathVariable("author") String author) {
        return messageService.serviceGetMessageByAuthor(author);
    }


//    update
    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") Long id, @RequestBody Message message) {
        return messageService.serviceUpdateMessage(id, message);
    }

//    delete
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<HttpStatus> deleteMessageById(@PathVariable("id") Long id){
        return messageService.serviceDeleteMessageById(id);
    }

}
