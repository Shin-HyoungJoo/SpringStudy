package com.example.demo.cmt.model;

import lombok.Data;

@Data
public class CmtSelDto {
    private Long iboard;
    private int page;
    private int row;
    private int startIdx;
}
