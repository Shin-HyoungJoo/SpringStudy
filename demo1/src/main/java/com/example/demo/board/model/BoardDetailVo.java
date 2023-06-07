package com.example.demo.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardDetailVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String createdAt;
    private String updatedAt;
    private String writer;
    private String writerMainPic;
}