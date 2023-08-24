package com.yocy.youngfriend.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author YounGCY
 * @date 2023-8-24 下午 12:52
 * @description 队伍和用户信息封装类（脱敏）
 */
@Data
public class TeamUserVO implements Serializable {
    private static final long serialVersionUID = 9122353255548218998L;
    /**
     * id
     */
    private Long id;

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
     * 创建时间
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     * 创建人的用户信息
     */
    UserVO createUser;
    
}
