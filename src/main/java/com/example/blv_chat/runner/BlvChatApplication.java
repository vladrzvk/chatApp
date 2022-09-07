package com.example.blv_chat.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BlvChatApplication {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BlvChatApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        String sql = "INSERT INTO stud (id, name) VALUES ("
//                + "1, 'ABC')";
//        int rows = jdbcTemplate.update (sql);
//        if (rows > 0) {
//            System.out.println ("One row inserted.");    }
//
}
