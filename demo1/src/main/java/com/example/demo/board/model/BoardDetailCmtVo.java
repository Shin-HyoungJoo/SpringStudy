package com.example.demo.board.model;

import com.example.demo.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardDetailCmtVo {
    private BoardDetailVo boardDetailVo;
    private CmtRes cmtRes;
}
