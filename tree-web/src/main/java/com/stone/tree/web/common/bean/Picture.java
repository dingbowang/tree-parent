package com.stone.tree.web.common.bean;

import java.io.Serializable;

/**
 * (Picture)实体类
 *
 * @author makejava
 * @since 2021-01-10 13:50:03
 */
public class Picture implements Serializable {
    private static final long serialVersionUID = -63642386726489117L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 图片url
    */
    private String picUrl;
    /**
    * 图片来源类型
    */
    private String picSourceType;
    /**
    * 图片分类
    */
    private String picType;
    /**
    * 状态(1:有效；0:无效)
    */
    private String status;

        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
        
    public String getPicSourceType() {
        return picSourceType;
    }

    public void setPicSourceType(String picSourceType) {
        this.picSourceType = picSourceType;
    }
        
    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Picture {" +
            "id : " + id + ", " +
            "picUrl : " + picUrl + ", " +
            "picSourceType : " + picSourceType + ", " +
            "picType : " + picType + ", " +
            "status : " + status + ", " +
        '}';
    }
}