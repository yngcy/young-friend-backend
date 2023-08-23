package com.yocy.youngfriend.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.util.ListUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author YounGCY
 * @date 2023-8-7 下午 5:34
 * @description
 */
public class ImportExcel {
    
    /**
     * 读取数据
     */
    public static void main(String[] args) throws Exception {
        String fileName = "D:\\java-workspace\\young-friend\\young-friend-backend\\src\\main\\resources\\test.xlsx";
        readByListener(fileName);
        synchronousRead(fileName);
    }

    /**
     * 监听器
     * @param fileName
     * @throws Exception
     */
    public static void readByListener(String fileName) throws Exception {
        EasyExcel.read(fileName, XingQiuTableInfo.class, new TableListener()).sheet().doRead();
    }

    /**
     * 同步读
     * @param fileName
     */
    public static void synchronousRead(String fileName) {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<XingQiuTableInfo> totalDataList = 
                EasyExcel.read(fileName).head(XingQiuTableInfo.class).sheet().doReadSync();
        for (XingQiuTableInfo info : totalDataList) {
            System.out.println(info);
        }
    }
}
