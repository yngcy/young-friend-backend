package com.yocy.youngfriend.utils;

import java.util.List;
import java.util.Objects;

/**
 * @author YounGCY
 * @date 2023-8-26 下午 2:42
 * @description
 */
public class AlgorithmUtils {

    public static int minTagsDistance(List<String> tagList1, List<String> tagList2) {
        int n = tagList1.size();
        int m = tagList2.size();

        if (n * m == 0) {
            return n + m;
        }

        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            f[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j - 1];
                if (!Objects.equals(tagList1.get(i - 1), tagList2.get(j - 1))) {
                    f[i][j]++;
                }
                f[i][j] = Math.min(f[i][j], Math.min( f[i - 1][j] + 1, f[i][j - 1] + 1));

            }
        }
        return f[n][m];
    }
    
    public static int minDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        if (n * m == 0) {
            return n + m;
        }
        
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            f[0][j] = j;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j - 1];
                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    f[i][j]++;
                }
                f[i][j] = Math.min(f[i][j], Math.min( f[i - 1][j] + 1, f[i][j - 1] + 1));
                
            }
        }
        return f[n][m];
    }
}
