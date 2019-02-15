package com.lizy.algorithms.leetcode;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-2-15 14:33
 */
public class LeetCode_69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        double last = 0,res = 1;
        while (last != res) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}
