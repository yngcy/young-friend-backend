package com.yocy.youngfriend.utils;

import org.junit.jupiter.api.Test;

/**
 * @author YounGCY
 * @date 2023-8-26 下午 2:40
 * @description
 */

public class AlgorithmUtilsTest {
    
    @Test
    public void test() {
        String s1 = "abcd";
        String s2 = "xax";

        System.out.println(AlgorithmUtils.minDistance(s1, s2));
    }
}
