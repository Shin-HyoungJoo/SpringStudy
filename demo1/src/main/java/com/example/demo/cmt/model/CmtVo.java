package com.example.demo.cmt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CmtVo {
    private Long iboardCmt;
    private Long iboard;
    private Long iuser;
    private String ctnt;
    private String createdAt;
    private String writer;
    private String mainPic;
}
