package com.bing.myblog.controller;


import com.bing.myblog.entity.Comment;
import com.bing.myblog.entity.UserInfo;
import com.bing.myblog.mapper.CommentMapper;
import com.bing.myblog.mapper.UserInfoMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommentController {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserInfoMapper userInfoMapper;


    //测试浏览器刷新后权限是否丢失(刷新后不会丢失权限，但前端vuex丢失store)
    //@RequiresPermissions("comment:add")
    @RequestMapping(value = "/getComments",method = RequestMethod.POST)
    public Map<String, Object> getComment(int articleId){
        System.out.println("POST /getcomments  articleId:"+articleId);
        Map<String, Object> map = new HashMap<>();
        List<Comment> comments = commentMapper.getByArticleId(articleId);
        for (Comment comment:comments) {
            UserInfo userInfo = userInfoMapper.getById(comment.getUserId());
            comment.setUserName(userInfo.getUserName());
        }
        map.put("comments", comments);
        return map;
    }

    @RequiresPermissions("comment:add")
    @RequestMapping(value = "/addComment",method = RequestMethod.POST)
    public Map<String, Object> addComment(int articleId, String detail){
        Map<String, Object> map = new HashMap<>();
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setCommentDetail(detail);
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("UserInfo");
        comment.setUserId(userInfo.getId());
        comment.setUserName(userInfo.getUserName());
        commentMapper.addComment(comment);
        map.put("result", "success");
        return map;
        //articleId:_this.articleId,detail:comment.detail
    }

    @RequiresPermissions("comment:delete")
    @RequestMapping(value = "/deleteComment",method = RequestMethod.POST)
    public Map<String, Object> deleteComment(int commentId){
        commentMapper.deleteCommentByid(commentId);
        Map<String, Object> map = new HashMap<>();
        map.put("result","success");
        return map;
    }
}
