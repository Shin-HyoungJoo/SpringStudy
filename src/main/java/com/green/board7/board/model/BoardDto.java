package com.green.board7.board.model;

import lombok.Data;

//페이징(페이지 관련 데이터) 받은거 저장
@Data
public class BoardDto extends BoardEntity{
    private int page;
    private int startIdx;
    private int rowLen;
}