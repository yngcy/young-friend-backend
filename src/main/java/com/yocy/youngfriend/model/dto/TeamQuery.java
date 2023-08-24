package com.yocy.youngfriend.model.dto;

import com.yocy.youngfriend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author YounGCY
 * @date 2023-8-23 下午 7:59
 * @description 队伍查询封装类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TeamQuery extends PageRequest {
    /**
     * id
     */
    private Long id;

    /**
     * 搜索关键词，同时对队伍名称和描述搜索
     */
    private String searchText;

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
     * 用户id
     */
    private Long userId;

    /**
     * 状态 0 - 公开，1 - 私有，2 - 保护
     */
    private Integer status;

    
}
