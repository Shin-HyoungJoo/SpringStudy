package com.example.demo.cmt;

import com.example.demo.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class CmtController {
    private final CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }

    @PostMapping("/{iboard}/cmt")
    public Long postCmt(@PathVariable Long iboard,
                       @RequestBody CmtInsDto dto) {
        CmtEntity entity = new CmtEntity();
        entity.setIboard(iboard);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.insCmt(entity);  //autocre된 cmt값
    }
    @DeleteMapping("/cmt/{iboardCmt}")
    public Long delCmt(@PathVariable Long iboardCmt,
                      @RequestParam Long iuser) {
        CmtDelDto dto = new CmtDelDto();
        dto.setIboardCmt(iboardCmt);
        dto.setIuser(iuser);
        return service.delCmt(dto);
    }

    @PutMapping("/cmt/{iboardCmt}")
    public Long putCmt(@PathVariable Long iboardCmt,
                      @RequestBody CmtUpdDto dto) {
        CmtEntity entity = new CmtEntity();
        entity.setIboardCmt(iboardCmt);
        entity.setIuser(dto.getIuser());
        entity.setCtnt(dto.getCtnt());
        return service.updCmt(entity);
    }

    @GetMapping("/{iboard}/cmt")
    public CmtRes getCmt(@PathVariable Long iboard,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "5") int row) {
        CmtSelDto dto = new CmtSelDto();
        dto.setIboard(iboard);
        dto.setPage(page);
        dto.setRow(row);
        return service.selCmt(dto);
    }
}

