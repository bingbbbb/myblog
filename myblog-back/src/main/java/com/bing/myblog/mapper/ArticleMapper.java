package com.bing.myblog.mapper;

import com.bing.myblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    Article getById(int id);

    List<Article> getAll();

    int addArticle(Article article);

    int updateArticle(@Param("article") Article article);

    int deleteArticle(@Param("id") int id);
}
