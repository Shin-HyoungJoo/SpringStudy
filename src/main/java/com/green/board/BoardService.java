package com.green.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper mapper;   //mapper 클래스 변수를 통해 인터페이스 메소드에 접근할 수 있다.
                                        //오버라이딩?

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int insBoard(BoardEntity entity) {
        System.out.println("service-insBoard");
        return mapper.insBoard(entity);
    }

    public int updBoard(BoardEntity entity) {
        return mapper.updBoard(entity);
    }

    public int delBoard(BoardEntity entity) {
        return mapper.delBoard(entity);
    }

    public List<BoardEntity> selBoardAll() {
        return mapper.selBoardAll();
    }

    public BoardEntity selBoardById(BoardEntity entity) {
        return mapper.selBoardById(entity);
    }
}
