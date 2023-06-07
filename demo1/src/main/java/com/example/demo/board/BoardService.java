package com.example.demo.board;

import com.example.demo.board.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardInsDto dto) {
        return mapper.insBoard(dto);
    }

    public int updBoard(BoardUpdDto dto) {
        return mapper.updBoard(dto);
    }

    public int delBoard(BoardDelDto dto) {
        return mapper.delBoard(dto);
    }
    //startIdx = limit 첫번째 값 0 30 60 90
    public List<BoardVo> selBoard(BoardDto dto) {
        dto.setStartIdx(dto.getRow()*(dto.getPage()-1));
        return mapper.selBoard(dto);
    }

    public BoardDetailVo selBoardDetail(BoardDetailDto dto) {
        return mapper.selBoardDetail(dto);
    }
}
