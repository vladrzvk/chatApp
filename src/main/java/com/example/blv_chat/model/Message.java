package com.example.blv_chat.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //    public Utilisateurs author;
    @Column(name="date")
    public Date date;
    @Column(name="content", nullable = false)
    public String content;
    @Column(name="user", nullable = false)
    public String author;

    public Message(String author, Date date, String content) {
        this.author = author;
        this.date = date;
        this.content = content;
    }

    public Message() {}
    public Long getId() {
        return id;
    }
    public Date getDate(){
        return date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }
    @Override
    public String toString() {
        return "Message{" +
                "author=" + author +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }

}
