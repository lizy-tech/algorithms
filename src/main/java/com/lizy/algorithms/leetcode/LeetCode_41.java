package com.lizy.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-10-8 20:46
 */
public class LeetCode_41 {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        int count = 1;
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
            while (set.contains(count)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }
}
