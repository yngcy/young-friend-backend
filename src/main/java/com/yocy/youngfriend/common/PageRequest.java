package com.yocy.youngfriend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YounGCY
 * @date 2023-8-23 下午 8:16
 * @description 通用分页请求参数
 */
@Data
public class PageRequest implements Serializable {


    private static final long serialVersionUID = -3102526653369630006L;
    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前页码
     */
    protected int pageNum = 1;
}
