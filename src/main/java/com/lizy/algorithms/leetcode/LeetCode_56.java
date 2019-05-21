package com.lizy.algorithms.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-5-20 9:27
 */
public class LeetCode_56 {
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        int i = 0;
        int j = 1;
        while (true){
            if (j < length) {
                if (intervals[i][1] >= intervals[j][0]) {
                    intervals[i][1] = intervals[i][1] >= intervals[j][1] ? intervals[i][1] : intervals[j][1];
                    j++;
                } else {
                    i++;
                    intervals[i] = intervals[j];
                    j++;
                }
            } else {
                break;
            }
        }
        int[][] res = new int[i+1][2];
        for (int k = 0; k <= i; k++) {
            res[k] = intervals[k];
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] data = {{1,4},{4,6},{8,10},{15,18}};
        int[][] res = merge(data);
        System.out.println(data[0]);
        int a = 0;
    }
}
