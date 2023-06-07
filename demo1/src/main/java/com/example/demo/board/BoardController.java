package com.example.demo.board;

import com.example.demo.board.model.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public int insBoard(@RequestBody BoardInsDto dto) {
        return service.insBoard(dto);
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
    public BoardDetailVo getBoardDetail(@PathVariable int iboard) {
        BoardDetailDto dto = new BoardDetailDto();
        dto.setIboard(iboard);
        return service.selBoardDetail(dto);
    }
}
