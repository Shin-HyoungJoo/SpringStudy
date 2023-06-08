package com.example.demo.user;

import com.example.demo.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public int postUser (@RequestBody UserInsDto dto) {
        return service.insUser(dto);
    }

    @PutMapping
    public int putUser (@RequestBody UserUpdDto dto) {
        return service.updUser(dto);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "" +
            "리턴값 : " +
            "(1) 로그인 성공 <br>" +
            "(2) 아이디 없음 <br>" +
            "(3) 비밀번호 다름")
    public int Login(@RequestBody UserLoginDto dto) {
        return service.Login(dto);
    }

    @PutMapping(value = "/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int putPicUser(@RequestPart MultipartFile pic, @RequestParam int iuser){
        UserPatchDto dto = new UserPatchDto();
        dto.setIuser(iuser);
        return service.updUserPic(dto,pic);
    }
}
