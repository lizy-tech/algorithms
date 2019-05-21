package com.lizy.algorithms.leetcode;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-5-20 16:03
 */
public class LeetCode_59 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int index = 1;
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = index++;
            }
            rowBegin++;
            if (rowBegin > rowEnd) {
                break;
            }
            for (int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = index++;
            }
            colEnd--;
            if (colEnd < colBegin) {
                break;
            }
            for (int i = colEnd; i >= colBegin; i--) {
                res[rowEnd][i] = index++;
            }
            rowEnd--;
            if (rowBegin > rowEnd) {
                break;
            }

            for (int i = rowEnd; i >= rowBegin; i--) {
                res[i][colBegin] = index++;
            }
            colBegin++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        int a = 0;
    }
}
