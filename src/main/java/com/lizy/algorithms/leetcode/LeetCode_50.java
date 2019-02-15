package com.lizy.algorithms.leetcode;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-2-15 13:26
 */
public class LeetCode_50 {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / myPowPositive(x, -n);
        } else {
            return myPowPositive(x, n);
        }
    }

    public double myPowPositive(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double tmp = myPowPositive(x, n / 2);
        double res = tmp * tmp;
        if (n %2 != 0) {
            res = res * x;
        }
        return res;
    }
}
