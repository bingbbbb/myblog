package com.bing.myblog.controller;


import com.bing.myblog.entity.UserInfo;
import com.bing.myblog.servics.ArticleService;
import com.bing.myblog.servics.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> returnData = new HashMap<>();
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            returnData.put("result", "success");
            UserInfo userInfo = loginService.getByUserName(username);
            returnData.put("username",userInfo.getUserName());
            returnData.put("permissions",userInfo.getPermissions().split(";"));
        } catch (AuthenticationException e) {
            returnData.put("result", "fail");
        }
        return returnData;
    }
}
