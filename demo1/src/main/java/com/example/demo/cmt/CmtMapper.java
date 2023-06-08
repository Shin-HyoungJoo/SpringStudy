package com.example.demo.cmt;

import com.example.demo.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    Long insCmt (CmtEntity entity);
    Long delCmt (CmtDelDto dto);
    Long updCmt (CmtEntity dto);
    List<CmtVo> selCmt (CmtSelDto dto);
    Long selCountCmt (CmtSelDto dto);
}