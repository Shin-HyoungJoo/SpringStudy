package com.green.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public int boardPost(@RequestBody BoardEntity entity) {
        System.out.println(entity);
        return service.insBoard(entity);
    }

    @PutMapping
    public int boardPut(@RequestBody BoardEntity entity) {
        System.out.println(entity);
        return service.updBoard(entity);
    }
    /* 쿼리스트링 방식
         @DeleteMapping
        public int boardDel(int iboard) {
            System.out.println(iboard);
            return service.delBoard(iboard);
        }
    */
    @DeleteMapping("/{iboard}")
    public int boardDel(@PathVariable int iboard) {
        BoardEntity entity = new BoardEntity();
        entity.setIboard(iboard);   //entity객체에 iboard값을 담아서 보낸다.
        System.out.println(entity);
        return service.delBoard(entity);    //iboard값을 받아서 리턴한다
    }

    @GetMapping
    public List<BoardEntity> boardGetAll() {
        return service.selBoardAll();
    }

    @GetMapping("/{iboard}")
    public BoardEntity GetBoardByIdAll(@PathVariable int iboard) {
        BoardEntity entity = new BoardEntity();
        entity.setIboard(iboard);
        return service.selBoardById(entity);
    }
}
