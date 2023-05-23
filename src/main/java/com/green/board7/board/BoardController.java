package com.green.board7.board;

import com.green.board7.board.model.BoardInsDto;
import com.green.board7.board.model.BoardDetailVo;
import com.green.board7.board.model.BoardDto;
import com.green.board7.board.model.BoardVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="게시판", description = "게시판 CRUD")
@RestController //얘도 Bean등록은 해준다
@Validated  //유효성 검사
@RequestMapping("/board")
public class BoardController {
    private final Logger LOGGER;
    private final BoardService service;

    @Autowired
    public BoardController(BoardService service) {
        LOGGER = LoggerFactory.getLogger(BoardController.class);
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "글등록", description = "글 등록을 할 수 있습니다.")
    public int postBoard(@RequestBody BoardInsDto dto) {
        LOGGER.warn("경고, 글 등록이 됩니다.");
        return service.insBoard(dto);
    }

    @GetMapping
    public List<BoardVo> getBoard(@RequestParam @Min(1) int page,
                                  @RequestParam(defaultValue = "30") int row) {
        LOGGER.info("page : " + page);
        BoardDto dto = new BoardDto();
        dto.setPage(page);
        dto.setRowLen(row);
        return service.selBoardAll(dto);
    }

    @GetMapping("/{iboard}")
    public BoardDetailVo getBoardById(@PathVariable int iboard) {
        BoardDto dto = new BoardDto();
        dto.setIboard(iboard);
        LOGGER.info(dto.toString());
        return service.selBoardById(dto);
    }

    @PutMapping
    public int putBoard(@RequestBody BoardDto dto) {
        return service.updBoard(dto);
    }

    @DeleteMapping("/{iboard}")
    public int delBoard(@PathVariable int iboard) {
        BoardDto dto = new BoardDto();
        dto.setIboard(iboard);
        return service.delBoard(dto);
    }
}
