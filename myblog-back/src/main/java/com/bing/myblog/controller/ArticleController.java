package com.bing.myblog.controller;


import com.bing.myblog.entity.Article;
import com.bing.myblog.servics.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;


    @RequestMapping(value = "/articles",method = RequestMethod.GET)
    public Map<String, Object> getArticle(){
        Map<String, Object> map = new HashMap<>();
        map.put("articles", articleService.getAll());
        return map;
    }

    @RequestMapping(value = "/article",method = RequestMethod.POST)
    public Map<String, Object> getArticleById(int articleId){
        Map<String, Object> map = new HashMap<>();
        Article article = articleService.getById(articleId);
        map.put("article", article);
        return map;
    }
}
