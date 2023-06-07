package com.example.demo.board;

import com.example.demo.board.model.*;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
    int updBoard(BoardUpdDto dto);
    int delBoard(BoardDelDto dto);
    List<BoardVo> selBoard(BoardDto dto);
    BoardDetailVo selBoardDetail(BoardDetailDto dto);

}
