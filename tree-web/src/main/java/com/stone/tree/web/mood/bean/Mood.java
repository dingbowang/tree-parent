package com.stone.tree.web.mood.bean;

import java.io.Serializable;

/**
 * (Mood)实体类
 *
 * @author makejava
 * @since 2021-01-10 13:49:42
 */
public class Mood implements Serializable {
    private static final long serialVersionUID = 149102355300784327L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 内容
    */
    private String content;
    /**
    * 图片链接
    */
    private String picUrl;
    /**
    * 范围（1:公开；2:好友；3隐私）
    */
    private String moodRange;
    
    private String moodRangeZh;
    /**
    * 主题（0:其他;1:日常；2:学习；3:娱乐）
    */
    private String moodTopic;
    
    private String moodTopicZh;
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
        
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
        
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
        
    public String getMoodRange() {
        return moodRange;
    }

    public void setMoodRange(String moodRange) {
        this.moodRange = moodRange;
    }
        
    public String getMoodRangeZh() {
        return moodRangeZh;
    }

    public void setMoodRangeZh(String moodRangeZh) {
        this.moodRangeZh = moodRangeZh;
    }
        
    public String getMoodTopic() {
        return moodTopic;
    }

    public void setMoodTopic(String moodTopic) {
        this.moodTopic = moodTopic;
    }
        
    public String getMoodTopicZh() {
        return moodTopicZh;
    }

    public void setMoodTopicZh(String moodTopicZh) {
        this.moodTopicZh = moodTopicZh;
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
        return "Mood {" +
            "id : " + id + ", " +
            "content : " + content + ", " +
            "picUrl : " + picUrl + ", " +
            "moodRange : " + moodRange + ", " +
            "moodRangeZh : " + moodRangeZh + ", " +
            "moodTopic : " + moodTopic + ", " +
            "moodTopicZh : " + moodTopicZh + ", " +
            "createTime : " + createTime + ", " +
            "createUserId : " + createUserId + ", " +
            "createUserName : " + createUserName + ", " +
            "updateTime : " + updateTime + ", " +
            "updateUser : " + updateUser + ", " +
            "status : " + status + ", " +
        '}';
    }
}