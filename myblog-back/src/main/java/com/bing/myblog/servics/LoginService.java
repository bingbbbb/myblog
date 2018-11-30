package com.bing.myblog.servics;

import com.bing.myblog.entity.UserInfo;
import com.bing.myblog.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo getByUserName(String userName){
        return userInfoMapper.getByUserName(userName);
    }

}
