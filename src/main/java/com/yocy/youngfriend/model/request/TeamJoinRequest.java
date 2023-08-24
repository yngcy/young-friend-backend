package com.yocy.youngfriend.model.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author YounGCY
 * @date 2023-8-24 下午 4:42
 * @description
 */
@Data
public class TeamJoinRequest implements Serializable {
    private static final long serialVersionUID = 853262529195795495L;
    /**
     * 队伍id
     */
    private Long teamId;

    

    /**
     * 密码
     */
    private String password;
    
}
