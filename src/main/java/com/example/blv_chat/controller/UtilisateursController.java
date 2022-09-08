package com.example.blv_chat.controller;

import com.example.blv_chat.model.Message;
import com.example.blv_chat.model.Utilisateurs;
import com.example.blv_chat.repository.UtilisateursRepository;
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
    UtilisateursRepository utilisateursRepository;

//    create
@PostMapping("/utilisateurs")
public ResponseEntity<Utilisateurs> createUtilisateurs(@RequestBody Utilisateurs user) {
    try {
        Utilisateurs _user = utilisateursRepository.save(
                new Utilisateurs(user.getUsername(), user.getPassword())
        );
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
//    request
@GetMapping("/utilisateurs")
public ResponseEntity<List<Utilisateurs>> getAllUtilisateurs(@RequestBody(required = false) String user){
    try
    {
        List<Utilisateurs> users = new ArrayList<Utilisateurs>();
        if(user == null){
            utilisateursRepository.findAll().forEach(users::add);
        }
        else
        {
            utilisateursRepository.findUtilisateursByUsername(user).forEach(users::add);
            if(users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    catch (Exception e)
    {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@GetMapping("/utilisateurs/{username}")
public ResponseEntity<Utilisateurs> getUtilisateursByUsername(@PathVariable("username") String user){
    Utilisateurs userFoundByUsername = (Utilisateurs) utilisateursRepository.findUtilisateursByUsername(user);
    if (userFoundByUsername == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(userFoundByUsername, HttpStatus.OK);
    }
}
}
//    update


//    delete



