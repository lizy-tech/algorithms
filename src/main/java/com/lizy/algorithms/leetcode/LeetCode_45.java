package com.lizy.algorithms.leetcode;

import java.util.Scanner;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-10-15 10:53
 */
public class LeetCode_45 {
    public static int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        int[] jum = new int[len];

        jum[len-1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            int min = jum[i + 1];
            if (nums[i] + i >= len - 1) {
                jum[i] = 1;
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < len - 1) {
                    if (jum[i + j] < min) {
                        min = jum[i + j];
                    }
                }
            }
            jum[i] = min+1;
        }

        return jum[0];
    }

    public static int jump4(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int step = 0;
        int index = 0;
        int len = nums.length;
        int p = 0;
        while (p <= len-1) {
            if (p + nums[p] >= len) {
                return step;
            }
            int _max = -1;
            for (int i = p+1; i <= p+nums[p] ; i++) {
                if (_max < i + nums[i]) {
                    _max = i + nums[i];
                    index = i;
                }
            }
            step++;
            p = index;
        }
        return step;
    }

    public static int jump5(int[] nums) {
        int ret = 0 ;
        int curMax = 0;
        int curRch = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if (curRch < i) {
                ret++;
                curRch = curMax;
            }
            curMax = Math.max(curMax , i+nums[i]);
        }
        return ret;
    }


    public static boolean canJump(int[] nums) {
        if (nums[0] == 0) {
            if (nums.length == 1) {
                return true;
            }
            return false;
        }
        boolean flag = true;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                flag = false;
                for (int j = i-1; j >=0 ; j--) {
                    if (nums[j] + j > i) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false) {
                break;
            }
        }
        return flag;


    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = jump5(nums);
        boolean bo = canJump(nums);
        System.out.println(bo);

    }
}
