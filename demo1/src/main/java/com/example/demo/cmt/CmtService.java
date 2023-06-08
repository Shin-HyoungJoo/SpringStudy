package com.example.demo.cmt;

import com.example.demo.cmt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public long insCmt (CmtEntity entity) {
        try {
            Long result = mapper.insCmt(entity);

            if (result == 1) {
                return entity.getIboardCmt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Long delCmt (CmtDelDto dto) {
        return mapper.delCmt(dto);
    }

    public Long updCmt (CmtEntity entity) {
        return mapper.updCmt(entity);
    }

    public CmtRes selCmt (CmtSelDto dto) {
        Long count = mapper.selCountCmt(dto);
        int maxCmtPage = (int)Math.ceil((double) count/dto.getRow());
        int isMore = (dto.getPage() >= maxCmtPage) ? 0 : 1;

        int startIdx = ((dto.getPage()-1)* dto.getRow());
        dto.setStartIdx(startIdx);
        List<CmtVo> list = mapper.selCmt(dto);

        return CmtRes.builder()
                .maxCmtPage(maxCmtPage)
                .row(dto.getRow())
                .isMore(isMore)
                .list(list)
                .build();
    }
}
