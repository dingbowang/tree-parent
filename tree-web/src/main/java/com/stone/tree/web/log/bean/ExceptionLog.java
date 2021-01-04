package com.stone.tree.web.log.bean;

import java.util.Date;
import java.io.Serializable;

/**
 * (ExceptionLog)实体类
 *
 * @author makejava
 * @since 2021-01-03 14:34:13
 */
public class ExceptionLog implements Serializable {
    private static final long serialVersionUID = 635717300836212622L;
    /**
    * 主键id
    */
    private String excId;
    /**
    * 请求参数
    */
    private String excReqParam;
    /**
    * 异常名称
    */
    private String excName;
    /**
    * 异常信息
    */
    private String excMessage;
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

        
    public String getExcId() {
        return excId;
    }

    public void setExcId(String excId) {
        this.excId = excId;
    }
        
    public String getExcReqParam() {
        return excReqParam;
    }

    public void setExcReqParam(String excReqParam) {
        this.excReqParam = excReqParam;
    }
        
    public String getExcName() {
        return excName;
    }

    public void setExcName(String excName) {
        this.excName = excName;
    }
        
    public String getExcMessage() {
        return excMessage;
    }

    public void setExcMessage(String excMessage) {
        this.excMessage = excMessage;
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
        return "ExceptionLog {" +
            "excId : " + excId + ", " +
            "excReqParam : " + excReqParam + ", " +
            "excName : " + excName + ", " +
            "excMessage : " + excMessage + ", " +
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