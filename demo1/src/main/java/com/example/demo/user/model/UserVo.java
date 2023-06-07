package com.example.demo.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserVo {
    private int iuser;
    private String uid;
    private String pw;
    private String nm;
    private String gender;
    private String addr;
    private String main_pic;
}
