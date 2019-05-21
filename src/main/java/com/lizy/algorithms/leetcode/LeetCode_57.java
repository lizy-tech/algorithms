package com.lizy.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-5-20 13:52
 */
public class LeetCode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        int lenb = newInterval.length;
        if (lenb == 0) {
            return intervals;
        }
        if (length == 0) {
            int[][] tem = {{newInterval[0], newInterval[1]}};
            return tem;
        }
        int index = 0;
        List<int[]> list = new ArrayList<>();
        while (index < length && intervals[index][1] < newInterval[0]) {
            list.add(intervals[index++]);
        }
        while (index < length && isOverlapped(newInterval, intervals[index])) {
            newInterval = overlap(newInterval, intervals[index++]);
        }
        list.add(newInterval);
        while (index < length) {
            list.add(intervals[index++]);
        }
        return parseIntervals(list);
    }

    private boolean isOverlapped(int[] a, int[] b) {
        return !(a[1] < b[0] || a[0] > b[1]);
    }

    private int[] overlap(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    private int[][] parseIntervals(List<int[]> list) {
        int[][] res = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
