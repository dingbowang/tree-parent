package com.stone.tree.web.comment.bean;

import java.io.Serializable;

/**
 * (BlogComment)实体类
 *
 * @author makejava
 * @since 2021-01-09 10:00:05
 */
public class BlogComment implements Serializable {
    private static final long serialVersionUID = -69536285718089371L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 评论id
    */
    private String commentId;
    /**
    * 文章id
    */
    private String blogId;
    /**
    * 状态
    */
    private String status;

        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
        
    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "BlogComment {" +
            "id : " + id + ", " +
            "commentId : " + commentId + ", " +
            "blogId : " + blogId + ", " +
            "status : " + status + ", " +
        '}';
    }
}