package com.bing.myblog.servics;

import com.bing.myblog.entity.Comment;
import com.bing.myblog.entity.UserInfo;
import com.bing.myblog.mapper.CommentMapper;
import com.bing.myblog.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public List<Comment> getByArticleId(int articleId){
        return commentMapper.getByArticleId(articleId);
    }

    public int addComment(Comment comment){
        return commentMapper.addComment(comment);
    }

    public int deleteCommentByid(int commentId){
        return commentMapper.deleteCommentByid(commentId);
    }


}
