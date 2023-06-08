package com.example.demo.cmt.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CmtRes {
    private int maxCmtPage;
    private int row;
    private int isMore;
    private List<CmtVo> list;
}
