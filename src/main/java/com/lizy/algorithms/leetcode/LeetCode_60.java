package com.lizy.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-5-20 17:14
 */
public class LeetCode_60 {
    public static String getPermutation(int n, int k) {
        if (n <= 1) {
            return n + "";
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        k = k-1;
        int leaf = n;
//        int val = 1;
//        for (int i = 0; i < n; i++) {
//            val *= (i + 1);
//        }

        while (leaf > 0) {
            int val = 1;
            for (int i = 1; i <= leaf - 1; i++) {
                val = val * i;
            }
            int index = k/val;
            sb.append(list.get(index));
            list.remove(index);
            k = k%val;
            leaf--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4, k = 9;
        String res = getPermutation(n, k);
        int a = 0;
    }
}
