package com.example.demo.board;

import com.example.demo.board.model.*;
import lombok.Getter;
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
    public int insBoard(@RequestBody BoardInsDto dto) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        return service.insBoard(entity);
    }

    @PutMapping
    public int updBoard(@RequestBody BoardUpdDto dto) {
        return service.updBoard(dto);
    }

    @DeleteMapping
    public int delBoard(@RequestBody BoardDelDto dto) {
        return service.delBoard(dto);
    }

    @GetMapping
    public List<BoardVo> getBoard(@RequestParam (defaultValue = "1") int page,
                                  @RequestParam (defaultValue = "30") int row ) {
        BoardDto dto = new BoardDto();
        dto.setPage(page);
        dto.setRow(row);
        return service.selBoard(dto);
    }

    @GetMapping("/{iboard}")
    public BoardDetailCmtVo getBoardDetail(@PathVariable int iboard,
                                           @RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "5") int row) {
        BoardDto dto = new BoardDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return service.selBoardDetail(dto);
    }
}
