package com.yocy.youngfriend.utils;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author YounGCY
 * @date 2023-8-7 下午 9:04
 * @description 导入星球用户到数据库
 */
public class ImportXingQiuUser {
    public static void main(String[] args) {
        String fileName = "D:\\java-workspace\\young-friend\\young-friend-backend\\src\\main\\resources\\test.xlsx";
        List<XingQiuTableInfo> userInfoList =
                EasyExcel.read(fileName).head(XingQiuTableInfo.class).sheet().doReadSync();
        System.out.println("总数：" + userInfoList.size());
        Map<String, List<XingQiuTableInfo>> listMap = 
                userInfoList.stream()
                        .filter(userInfo -> StringUtils.isNotEmpty(userInfo.getUsername()))
                        .collect(Collectors.groupingBy(XingQiuTableInfo::getUsername));
        System.out.println("不重复的昵称数：" + listMap.keySet().size());
    }
}
