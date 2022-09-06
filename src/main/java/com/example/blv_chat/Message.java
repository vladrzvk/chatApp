package com.example.blv_chat;
import java.util.Date;

public class Message {
//    public Utilisateurs author;
    public Date date;
    public String content;
    public String author;
    public Message(String author, Date date, String content) {
        this.author = author;
        this.date = date;
        this.content = content;
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
