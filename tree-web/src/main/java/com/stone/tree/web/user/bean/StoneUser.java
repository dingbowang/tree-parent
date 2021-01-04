package com.stone.tree.web.user.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户(StoneUser)实体类
 *
 * @author makejava
 * @since 2021-01-03 12:50:40
 */
@ApiModel("用户实体类")
public class StoneUser implements Serializable {
    private static final long serialVersionUID = 397497227122024211L;
    /**
    * 编号
    */
    @ApiModelProperty("id")
    private String id;
    /**
    * 手机
    */
    @ApiModelProperty("手机号")
    private String mobile;
    /**
    * 密码
    */
    @ApiModelProperty("密码")
    private String password;
    /**
    * 昵称
    */
    @ApiModelProperty("用户名")
    private String nickname;
    /**
    * 性别
    0：未知
    1：男
    2：女
    */
    private String gender;
    /**
    * 年龄
    */
    private String age;
    /**
     * 邮箱
     */
    private String email;
    /**
    * 头像
    */
    private String photo;
    /**
    * 是否可用
0：冻结
1：可用
    */
    private String enabled;
    /**
    * 备注信息
    */
    private String remarks;
    /**
    * 创建时间
    */
    private Date createDate;
    /**
    * 更新时间
    */
    private Date updateDate;
    /**
    * 删除标记
    1：删除
    0：未删除
    */
    private String delFlag;

        
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
        
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
        
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
        
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
        
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
        
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
        
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
        
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
        
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString(){
        return "StoneUser {" +
                "id : " + id + ", " +
                "mobile : " + mobile + ", " +
                "password : " + password + ", " +
                "nickname : " + nickname + ", " +
                "gender : " + gender + ", " +
                "age : " + age + ", " +
                "email : " + email + ", " +
                "photo : " + photo + ", " +
                "enabled : " + enabled + ", " +
                "remarks : " + remarks + ", " +
                "createDate : " + createDate + ", " +
                "updateDate : " + updateDate + ", " +
                "delFlag : " + delFlag + ", " +
                '}';
    }
}