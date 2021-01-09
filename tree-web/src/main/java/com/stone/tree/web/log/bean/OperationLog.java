package com.stone.tree.web.log.bean;

import java.util.Date;
import java.io.Serializable;

/**
 * (OperationLog)实体类
 *
 * @author makejava
 * @since 2021-01-09 14:13:47
 */
public class OperationLog implements Serializable {
    private static final long serialVersionUID = -83198126607668100L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 功能模块
    */
    private String operModule;
    /**
    * 操作类型
    */
    private String operType;
    /**
    * 操作描述
    */
    private String operDesc;
    /**
    * 请求参数
    */
    private String operReqParam;
    /**
    * 返回参数
    */
    private String operRespParam;
    /**
    * 操作人id
    */
    private String operUserId;
    /**
    * 操作人姓名
    */
    private String operUserName;
    /**
    * 操作方法
    */
    private String operMethod;
    /**
    * 请求uri
    */
    private String operUri;
    /**
    * 请求ip
    */
    private String operIp;
    /**
    * 请求时间
    */
    private Date operCreateTime;
    /**
    * 操作版本号
    */
    private String operVer;

        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    public String getOperModule() {
        return operModule;
    }

    public void setOperModule(String operModule) {
        this.operModule = operModule;
    }
        
    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }
        
    public String getOperDesc() {
        return operDesc;
    }

    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc;
    }
        
    public String getOperReqParam() {
        return operReqParam;
    }

    public void setOperReqParam(String operReqParam) {
        this.operReqParam = operReqParam;
    }
        
    public String getOperRespParam() {
        return operRespParam;
    }

    public void setOperRespParam(String operRespParam) {
        this.operRespParam = operRespParam;
    }
        
    public String getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }
        
    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }
        
    public String getOperMethod() {
        return operMethod;
    }

    public void setOperMethod(String operMethod) {
        this.operMethod = operMethod;
    }
        
    public String getOperUri() {
        return operUri;
    }

    public void setOperUri(String operUri) {
        this.operUri = operUri;
    }
        
    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }
        
    public Date getOperCreateTime() {
        return operCreateTime;
    }

    public void setOperCreateTime(Date operCreateTime) {
        this.operCreateTime = operCreateTime;
    }
        
    public String getOperVer() {
        return operVer;
    }

    public void setOperVer(String operVer) {
        this.operVer = operVer;
    }

    @Override
    public String toString(){
        return "OperationLog {" +
            "id : " + id + ", " +
            "operModule : " + operModule + ", " +
            "operType : " + operType + ", " +
            "operDesc : " + operDesc + ", " +
            "operReqParam : " + operReqParam + ", " +
            "operRespParam : " + operRespParam + ", " +
            "operUserId : " + operUserId + ", " +
            "operUserName : " + operUserName + ", " +
            "operMethod : " + operMethod + ", " +
            "operUri : " + operUri + ", " +
            "operIp : " + operIp + ", " +
            "operCreateTime : " + operCreateTime + ", " +
            "operVer : " + operVer + ", " +
        '}';
    }
}