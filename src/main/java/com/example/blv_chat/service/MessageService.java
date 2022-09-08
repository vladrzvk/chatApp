package com.example.blv_chat.service;

import com.example.blv_chat.model.Message;
import com.example.blv_chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public ResponseEntity<Message> serviceCreateMessage(Message message) {
        try {
            Message _message = messageRepository.save(
                    new Message(message.getAuthor(), message.getDate(), message.getAuthor())
            );
            return new ResponseEntity<>(_message, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Message>> serviceGetAllMessage(String content){
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

    public ResponseEntity<Message> serviceGetMessageById(Long id){
        Optional<Message> messageFoundById = messageRepository.findById(id);
        if (messageFoundById.isPresent()) {
            return new ResponseEntity<>(messageFoundById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Message> serviceGetMessageByAuthor(String author){
        Optional<Message> messageFoundByAuthor = messageRepository.findMessageByAuthor(author);
        if (messageFoundByAuthor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(messageFoundByAuthor.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Message> serviceUpdateMessage(Long id, Message message){
        Optional<Message> messageData = messageRepository.findById(id);

        if (messageData.isPresent()) {
            Message _message = messageData.get();
            _message.setAuthor(message.getAuthor());
            _message.setDate(message.getDate());
            _message.setContent(message.getContent());
            return new ResponseEntity<>(messageRepository.save(_message), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> serviceDeleteMessageById(Long id){
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
