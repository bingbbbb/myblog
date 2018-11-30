package com.bing.myblog.servics;

import com.bing.myblog.entity.Article;
import com.bing.myblog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public Article getById(int id){
        return articleMapper.getById(id);
    }

    public List<Article> getAll(){
        return articleMapper.getAll();
    }

    public int addArticle(Article article){return articleMapper.addArticle(article);}

    public int updateArticle(Article article){return articleMapper.updateArticle(article);}

    public int deleteArticle(int id){return articleMapper.deleteArticle(id);}

}
