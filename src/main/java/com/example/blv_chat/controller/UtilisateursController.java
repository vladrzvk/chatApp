package com.example.blv_chat.controller;

import com.example.blv_chat.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UtilisateursController {

    @Autowired
    UtilisateursRepository utilisateursRepository;

//    create

//    request
//    update
//    delete


}
