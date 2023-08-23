package com.yocy.youngfriend.utils;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author YounGCY
 * @date 2023-8-7 下午 5:38
 * @description 星球表格用户信息
 */
@Data
public class XingQiuTableInfo {

    /**
     * id
     */
    @ExcelProperty("成员编号")
    private String planetCode;

    /**
     * 用户昵称
     */
    @ExcelProperty("成员昵称")
    private String username;

    
}
