package com.example.blv_chat.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Utilisateurs  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="username", nullable = false, length = 150)
    private String username;
    @Column(name="password",nullable = false, length = 24)
    private String password;

    public Utilisateurs() {
    }
    public Utilisateurs(String username,String password) {
        this.username=username;
        this.password=password;
    }
    public Long getId() { return id;}

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }



    @Override
    public String toString() {
        return "Utilisateurs{}";
    }



    public void setPassword(String str){
        this.password = str;
    }
    public void setUsername(String str){ this.username = str;}



    @Override
    public int hashCode() {
        return Objects.hash(password);
    }




}
