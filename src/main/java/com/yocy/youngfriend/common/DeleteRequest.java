package com.yocy.youngfriend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author YounGCY
 * @date 2023-8-26 下午 1:54
 * @description 通用删除请求参数
 */
@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = 7681452979559009252L;
    
    private long id;
}
