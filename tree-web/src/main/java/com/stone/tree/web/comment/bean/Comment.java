package com.stone.tree.web.comment.bean;

import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2021-01-09 09:57:25
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 125031353116767146L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 父级id
    */
    private String parentId;
    /**
    * 评论
    */
    private String content;
    /**
    * 用户id
    */
    private String createUserId;
    /**
    * 用户名称
    */
    private String createUserName;
    /**
    * 评论类型（1:blog；）
    */
    private String commentType;
    
    private Long createTime;
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
        
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
        
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
        
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
        
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
        
    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }
        
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Comment {" +
            "id : " + id + ", " +
            "parentId : " + parentId + ", " +
            "content : " + content + ", " +
            "createUserId : " + createUserId + ", " +
            "createUserName : " + createUserName + ", " +
            "commentType : " + commentType + ", " +
            "createTime : " + createTime + ", " +
            "status : " + status + ", " +
        '}';
    }
}