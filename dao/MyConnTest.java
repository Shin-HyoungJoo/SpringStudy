package com.green.java.dao;

import com.green.java.dao.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyConnTest {
    public static void main(String[] args) {
        //page=2, row=30
        BoardDao dao = new BoardDao();
        BoardEntity dto = new BoardEntity();
        BoardUpdDto updDto = new BoardUpdDto();
        BoardSelDto selDto = new BoardSelDto();
        BoardDto dto1 = new BoardDto();
//        selDto.setIboard(2007);

        int page = 2;
        int row = 30;

        dto1.setPage(page);
        dto1.setRow(row);
        dto1.setStartIdx((page - 1) * row);

        List<BoardVo> list = dao.selBoard(dto1);
        for (BoardVo view: list) {
            System.out.println(view);
        }

//        BoardDetailVo result = dao.selBoardDetail(selDto);
//        System.out.println(result);

//        dto.setTitle("제목11");
//        dto.setCtnt("내용7");
//        dto.setIuser(8);
//
//        result = dao.insBoard(dto);
//        System.out.println(result);

//        updDto.setTitle("타이틀");
//        updDto.setCtnt("내용이다");
//        updDto.setIuser(8);
//        updDto.setIboard(2006);
//
//        result = dao.updBoard(updDto);
//        System.out.println(result);


    }
}
