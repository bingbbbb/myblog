package com.bing.myblog.mapper;
import com.bing.myblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CommentMapper {
    List<Comment> getByArticleId(int articleId);

    int addComment(Comment comment);

    int deleteCommentByid(int commentId);
}
