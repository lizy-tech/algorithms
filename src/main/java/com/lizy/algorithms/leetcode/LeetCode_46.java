package com.lizy.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-10-22 20:23
 */
public class LeetCode_46 {

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length == 0) {
            return result;
        }
        List<Integer> first = new LinkedList<>();
        first.add(0, nums[0]);
        result.add(first);
        List<Integer> temp;
        for (int i = 1; i < nums.length; i++) {
            int number = nums[i];
            do {
                temp = result.removeFirst();
                for (int j = 0; j <= temp.size(); j++) {
                    temp.add(j, number);
                    result.add(new LinkedList<>(temp));
                    temp.remove(j);
                }
            } while (result.getFirst().size() == i);
        }


        return result;


    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;

        dfs(nums, 0, res);
        return res;
    }

    private static void dfs(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            res.add(list);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            dfs(nums, idx + 1, res);
            swap(nums, idx, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> entry = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        loop(nums, res, entry, used);

        return res;
    }

    public static void loop(int[] nums, List<List<Integer>> res, List<Integer> entry, boolean[] used) {
        if (entry.size() == nums.length) {
            res.add(new ArrayList<Integer>(entry));
            entry = new ArrayList<>();
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                entry.add(nums[i]);
                loop(nums, res, entry, used);
                used[i] = false;
                entry.remove(entry.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        permute(nums);
        int a = 0;
    }
}

