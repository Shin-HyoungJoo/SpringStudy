package com.example.demo.board.model;

import lombok.Data;

@Data
public class BoardEntity {
    private long iboard;
    private String title;
    private String ctnt;
    private long iuser;
    private String created_at;
    private String updated_at;
}
