package com.lizy.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-3-29 11:37
 */
public class LeetCode_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int rowBegin = 0, rowEnd = m - 1, colBegin = 0, colEnd = n - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            if (rowBegin > rowEnd) {
                break;
            }

            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (colBegin > colEnd) {
                break;
            }

            for (int i = colEnd; i >= colBegin; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if (rowBegin > rowEnd) {
                break;
            }

            for (int i = rowEnd; i >= rowBegin; i--) {
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return res;



    }
}
