package com.green.board7.cmt;

import com.green.board7.cmt.model.BoardCmtDto;
import com.green.board7.cmt.model.BoardCmtInsDto;
import com.green.board7.cmt.model.BoardCmtVo;
import com.green.board7.cmt.model.BoardCmtDelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired      //DI하기 위해 한다
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoardCmt(BoardCmtInsDto cmtInsDto) {
        return mapper.insBoardCmt(cmtInsDto);
    }

    public int delBoardCmt(BoardCmtDelDto dto) {
        return mapper.delBoardCmt(dto);
    }

    public List<BoardCmtVo> selBoardCmt (BoardCmtDto dto) {
        return mapper.selBoardCmt(dto);
    }
}
