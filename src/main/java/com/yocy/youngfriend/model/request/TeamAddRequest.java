package com.yocy.youngfriend.model.request;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author YounGCY
 * @date 2023-8-24 上午 10:51
 * @description
 */
@Data
public class TeamAddRequest {
    
    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date expireTime;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 状态 0 - 公开，1 - 私有，2 - 保护
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;
    
    

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
