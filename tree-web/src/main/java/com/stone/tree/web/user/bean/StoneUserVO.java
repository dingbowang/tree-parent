package com.stone.tree.web.user.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dbw
 * @date 2021/01/10/9:59 下午
 * @Description
 */
@Data
public class StoneUserVO implements Serializable {
    private static final long serialVersionUID = 1637797293540834311L;
    /**
     * 编号
     */
    private String id;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
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
    /**
     * token
     */
    private String token;
}
