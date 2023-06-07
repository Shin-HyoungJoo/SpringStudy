package com.example.demo.user;

import com.example.demo.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser (UserInsDto dto);
    int updUser (UserUpdDto dto);
    int updUserPic (UserPatchDto dto);
    UserVo selUserDetail (UserLoginDto dto);
}
