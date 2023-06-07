package com.example.demo.cmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cmt")
public class CmtController {
    private CmtService service;

    @Autowired
    public CmtController(CmtService service) {
        this.service = service;
    }
}
