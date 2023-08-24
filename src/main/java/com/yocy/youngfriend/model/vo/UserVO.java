package com.yocy.youngfriend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YounGCY
 * @date 2023-8-24 下午 12:54
 * @description 用户包装类（脱敏）
 */
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = -2421330167402713278L;
    /**
     * id
     */
    private long id;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private Integer gender;
    
    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 标签列表 json
     */
    private String tags;

    /**
     * 简介
     */
    private String profile;

    /**
     * 状态 0 - 正常
     */
    private Integer userStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;
    

    /**
     * 用户角色 0 - 普通用户 1 - 管理员
     */
    private Integer userRole;

    /**
     * 星球编号
     */
    private String planetCode;
}
