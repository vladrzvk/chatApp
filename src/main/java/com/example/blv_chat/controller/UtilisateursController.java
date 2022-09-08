package com.example.blv_chat.controller;

import com.example.blv_chat.model.Message;
import com.example.blv_chat.model.Utilisateurs;
import com.example.blv_chat.repository.UtilisateursRepository;
import com.example.blv_chat.service.UtilisateursService;
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
public class UtilisateursController {

    @Autowired
    UtilisateursService utilisateursService;

//    create
    @PostMapping("/utilisateurs")
    public ResponseEntity<Utilisateurs> createUtilisateurs(@RequestBody Utilisateurs user) {
        return utilisateursService.serviceCreateUtilisateurs(user);
    }
    //    request
    @GetMapping("/utilisateurs")
    public ResponseEntity<List<Utilisateurs>> getAllUtilisateurs(@RequestBody(required = false) String user){
        return utilisateursService.serviceGetAllUtilisateurs(user);
    }

    @GetMapping("/utilisateurs/{username}")
    public ResponseEntity<Utilisateurs> getUtilisateursByUsername(@PathVariable("username") String user){
        return utilisateursService.serviceGetUtilisateursByUsername(user);
    }

//    update
    @PutMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateurs> updateUtilisateurs(@PathVariable("id") Long id, @RequestBody Utilisateurs user){
        return utilisateursService.serviceUpdateUtilisateurs(id, user);
    }

//    delete
    @DeleteMapping("/utilisateurs/{id}")
    public ResponseEntity<HttpStatus> deleteUtilisateursById(@PathVariable("id") Long id){
        return utilisateursService.serviceDeleteUtilisateursById(id);
    }


}




