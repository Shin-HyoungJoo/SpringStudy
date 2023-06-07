package com.example.demo.user;

import com.example.demo.user.model.*;
import com.example.demo.utils.CommonUtils;
import com.example.demo.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UserService {
    private UserMapper mapper;
    private CommonUtils utils;

    @Value("${file.dir}")
    private String fileDir;

    @Autowired
    public UserService(UserMapper mapper, CommonUtils utils) {
        this.mapper = mapper;
        this.utils = utils;
    }

    public int insUser (UserInsDto dto) {
        return mapper.insUser(dto);
    }

    public int updUser (UserUpdDto dto) {
        return mapper.updUser(dto);
    }

    public int updUserPic (UserPatchDto dto, MultipartFile pic) {
        String dicPath = String.format("%s/user/%d",fileDir,dto.getIuser());
        String saveFilePath = dicPath + "/" + FileUtils.makeRandomFileNm(pic.getOriginalFilename());
        File dic = new File(dicPath);
        File file = new File(saveFilePath);

        if(!dic.exists()) {
            dic.mkdirs();
        }

        try {
            pic.transferTo(file);
            dto.setIuser(dto.getIuser());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //검수
        try {
            int result = mapper.updUserPic(dto);
            if (result == 0) {
                throw new Exception("프로필 사진을 등록할 수 없습니다.");
            }
        } catch (Exception e) {
            file.delete();
            return 0;
        }

        return mapper.updUserPic(dto);
    }

    public int Login (UserLoginDto dto) {
        UserVo vo = mapper.selUserDetail(dto);

        if(vo == null) {
            System.out.println("아이디와 비밀번호를 입력하세요");
            return 2;
        }

        String hashedPw = utils.encodeSha256(dto.getPw());
        if(vo.getPw().equals(hashedPw)) {
            return 1;   //로그인 성공
        }

        System.out.println("아이디와 비밀번호를 확인하세요");
        return 3;
    }

}
