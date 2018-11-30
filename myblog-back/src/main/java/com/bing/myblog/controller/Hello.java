package com.bing.myblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Hello {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public Map<String, Object> showArticle(){
        Map<String, Object> map = new HashMap<>();
        map.put("title1", "It is title1 in Home.vue");
        return map;
    }
}