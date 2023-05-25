package com.green.board7.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardVo {  //select용
    private int iboard;
    private String title;
    private String writer;
    private String createdAt;
}
