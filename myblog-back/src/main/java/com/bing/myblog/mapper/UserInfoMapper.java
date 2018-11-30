package com.bing.myblog.mapper;

import com.bing.myblog.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    UserInfo getByUserName(String userName);

    UserInfo getById(int id);
}
