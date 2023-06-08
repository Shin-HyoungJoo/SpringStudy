package com.example.demo.board;

import com.example.demo.board.model.*;
import com.example.demo.cmt.CmtService;
import com.example.demo.cmt.model.CmtRes;
import com.example.demo.cmt.model.CmtSelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;
    private final CmtService cmtService;

    @Autowired
    public BoardService(BoardMapper mapper,  CmtService cmtService) {
        this.mapper = mapper;
        this.cmtService = cmtService;
    }

    public int insBoard(BoardEntity entity) {
        return mapper.insBoard(entity);
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

    public BoardDetailCmtVo selBoardDetail(BoardDto dto) {
        CmtSelDto dto1 = new CmtSelDto();
        dto1.setPage(dto.getPage());
        dto1.setIboard((long)dto.getIboard());
        dto1.setRow(dto.getRow());
        return BoardDetailCmtVo.builder()
                .boardDetailVo(mapper.selBoardDetail(dto))
                .cmtRes(cmtService.selCmt(dto1))
                .build();
    }
}
