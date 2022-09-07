package com.example.blv_chat.controller;

import com.example.blv_chat.model.Message;
import com.example.blv_chat.model.Utilisateurs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class FirstController {
    private static final String message = " mon message, %s!";
    Utilisateurs first_user = new Utilisateurs("toto","titi");
    Date date = new Date();
    private String author = first_user.getUsername();

    @GetMapping("/toto")
    public Message methodeDuMapping(){
        return new Message(author, date, String.format(message, author));
    }


}
