package com.example.blv_chat.repository;

import com.example.blv_chat.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long> {
    List<Utilisateurs> findUtilisateursByUsername(String str);
    Utilisateurs findUtilisateurByUsername(String str);
    Utilisateurs deleteUtilisateursById(Long id);

//    ajouter une recherche par privilege (admin etc)

}
