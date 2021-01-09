package com.stone.tree.web.blog.bean;

import java.io.Serializable;

/**
 * (Blog)实体类
 *
 * @author makejava
 * @since 2021-01-09 14:04:08
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = -43068583607036219L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 标题
    */
    private String title;
    /**
    * 内容
    */
    private String content;
    /**
    * 范围（1:公开；2:好友；3隐私）
    */
    private String blogRange;
    
    private String blogRangeZh;
    /**
    * 主题（0:其他;1:日常；2:学习；3:娱乐）
    */
    private String blogTopic;
    
    private String blogTopicZh;
    /**
    * 创建时间
    */
    private Long createTime;
    /**
    * 创建人id
    */
    private String createUserId;
    /**
    * 创建人名称
    */
    private String createUserName;
    /**
    * 更新时间
    */
    private Long updateTime;
    /**
    * 更新人
    */
    private String updateUser;
    /**
    * 状态值（1:有效；2:草稿；0:无效）
    */
    private String status;

        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
        
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
        
    public String getBlogRange() {
        return blogRange;
    }

    public void setBlogRange(String blogRange) {
        this.blogRange = blogRange;
    }
        
    public String getBlogRangeZh() {
        return blogRangeZh;
    }

    public void setBlogRangeZh(String blogRangeZh) {
        this.blogRangeZh = blogRangeZh;
    }
        
    public String getBlogTopic() {
        return blogTopic;
    }

    public void setBlogTopic(String blogTopic) {
        this.blogTopic = blogTopic;
    }
        
    public String getBlogTopicZh() {
        return blogTopicZh;
    }

    public void setBlogTopicZh(String blogTopicZh) {
        this.blogTopicZh = blogTopicZh;
    }
        
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
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
        
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
        
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Blog {" +
            "id : " + id + ", " +
            "title : " + title + ", " +
            "content : " + content + ", " +
            "blogRange : " + blogRange + ", " +
            "blogRangeZh : " + blogRangeZh + ", " +
            "blogTopic : " + blogTopic + ", " +
            "blogTopicZh : " + blogTopicZh + ", " +
            "createTime : " + createTime + ", " +
            "createUserId : " + createUserId + ", " +
            "createUserName : " + createUserName + ", " +
            "updateTime : " + updateTime + ", " +
            "updateUser : " + updateUser + ", " +
            "status : " + status + ", " +
        '}';
    }
}