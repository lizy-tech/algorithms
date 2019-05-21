package com.lizy.algorithms.leetcode;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-2-15 16:33
 */
public class LeetCode_372 {

    public static int myPow(int a,int b){
        int res = 1;
        if (b == 0) {
            return 1;
        }
        if (a == 1) {
            return 1;
        }
        for (int i = 0; i < b; i++) {
            res = res * ((a % 1337) % 1337);
        }
        return res;
    }


    public static int superPow(int a, int[] b) {
        int res = 1;
        if (a == 0 || a == 1) {
            return a;
        }
        a %= 1337;
        Arrays.sort(b);

        for (int i =  b.length-1; i >=0; i--) {
            res = res * myPow(a, b[i]) % 1337;
            a = myPow(a, 10);
        }

        return res;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int[] b = {2,0,0};
        superPow(a, b);
        int aa = 1;
    }
}
