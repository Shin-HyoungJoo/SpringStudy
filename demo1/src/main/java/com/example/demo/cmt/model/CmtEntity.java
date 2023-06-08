package com.example.demo.cmt.model;

import lombok.Data;

@Data
public class CmtEntity {
    private Long iboardCmt;
    private Long iboard;
    private Long iuser;
    private String ctnt;
    private String created_at;
    private String updated_at;
}