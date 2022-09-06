package com.example.blv_chat;
//import org.springframework.security.core.CredentialsContainer;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

// extends Object implements UserDetails, CredentialsContainer
@Entity
public class Utilisateurs  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;

    public Utilisateurs() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Utilisateurs{}";
    }

//    public Utilisateurs(String username,
//                        String password,
//                        Collection<? extends GrantedAuthority> authorities) {
//        this.username= username;
//        this.password=password;
//    }

    public Utilisateurs(String username,
                        String password) {
        this.username=username;
        this.password=password;
    }

    public void setUsername(String str){
        this.username = str;
    }
    public void setPassword(String str){
        this.password = str;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Utilisateurs that = (Utilisateurs) o;
//        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    public void eraseCredentials() {
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }


    public String getPassword() {
        return this.password;
    }


    public String getUsername() {
        return this.username;
    }



}
