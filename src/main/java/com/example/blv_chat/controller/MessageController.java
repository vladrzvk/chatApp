package com.example.blv_chat.controller;


import com.example.blv_chat.model.Message;
import com.example.blv_chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    //    create
    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        try {
            Message _message = messageRepository.save(
                    new Message(message.getAuthor(), message.getDate(), message.getAuthor())
            );
            return new ResponseEntity<>(_message, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    request
    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessage(@RequestParam(required = false) String content) {
        try {
            List<Message> message = new ArrayList<Message>();
            if (content == null)
                messageRepository.findAll().forEach(message::add);
            else
                messageRepository.findMessageByContent(content).forEach(message::add);
            if (message.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id) {
        Optional<Message> messageFoundById = messageRepository.findById(id);
        if (messageFoundById.isPresent()) {
            return new ResponseEntity<>(messageFoundById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/messages/{author}")
    public ResponseEntity<Message> getMessageByAuthor(@PathVariable("author") String author) {
        Optional<Message> messageFoundByAuthor = messageRepository.findMessageByAuthor(author);
        if (messageFoundByAuthor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(messageFoundByAuthor.get(), HttpStatus.OK);
        }
    }


//    update
    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable("id") Long id, @RequestBody Message message) {
        Optional<Message> tutorialData = messageRepository.findById(id);
        if (tutorialData.isPresent()) {
            Message _message = tutorialData.get();
            _message.setAuthor(message.getAuthor());
            _message.setDate(message.getDate());
            _message.setContent(message.getContent());
            return new ResponseEntity<>(messageRepository.save(_message), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    delete
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<HttpStatus> deleteMessageById(@PathVariable("id") Long id){
        try
        {
            messageRepository.deleteMessageById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
