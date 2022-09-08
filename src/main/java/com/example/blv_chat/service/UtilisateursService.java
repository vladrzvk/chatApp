package com.example.blv_chat.service;

import com.example.blv_chat.model.Message;
import com.example.blv_chat.model.Utilisateurs;
import com.example.blv_chat.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UtilisateursService {

    @Autowired
    UtilisateursRepository utilisateursRepository;

    public ResponseEntity<Utilisateurs> serviceCreateUtilisateurs(Utilisateurs user) {
        try {
            Utilisateurs _user = utilisateursRepository.save(
                    new Utilisateurs(user.getUsername(), user.getPassword())
            );
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Utilisateurs>> serviceGetAllUtilisateurs(String user){
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

    public ResponseEntity<Utilisateurs> serviceGetUtilisateursByUsername(String user){
        Utilisateurs userFoundByUsername = (Utilisateurs) utilisateursRepository.findUtilisateursByUsername(user);
        if (userFoundByUsername == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(userFoundByUsername, HttpStatus.OK);
        }
    }

    public ResponseEntity<Utilisateurs> serviceUpdateUtilisateurs(Long id, Utilisateurs user){
        Optional<Utilisateurs> userData = utilisateursRepository.findById(id);
        if (userData.isPresent()) {
            Utilisateurs _user = userData.get();
            _user.setUsername(user.getUsername());
            _user.setPassword(user.getPassword());
            return new ResponseEntity<>(utilisateursRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> serviceDeleteUtilisateursById(Long id){
        try
        {
            utilisateursRepository.deleteUtilisateursById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
