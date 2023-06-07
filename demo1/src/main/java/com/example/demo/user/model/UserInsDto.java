package com.example.demo.user.model;

import lombok.Data;

@Data
public class UserInsDto {
    private int uid;
    private int pw;
    private String nm;
    private String gender;
    private String addr;
}
