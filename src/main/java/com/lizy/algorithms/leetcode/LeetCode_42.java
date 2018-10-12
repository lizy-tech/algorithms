package com.lizy.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-10-9 19:39
 */
public class LeetCode_42 {
    public static int trap(int[] height) {
        int length = height.length;
        if(length<=2){
            return 0;
        }

        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        s.push(0);
        index.push(1);

        int leftMost = 0;
        int result = 0;
        for(int i = 0 ; i<length ; i++){
            int currentVal = height[i];
            //如果当前值比最左值大，则说明形成了一个封闭的盛水区间
            if(currentVal >= leftMost){
                while(!s.isEmpty()){
                    result += (leftMost - s.pop()) * index.pop();
                }
                s.push(currentVal);
                index.push(1);
                leftMost = currentVal;
            }else{
                //如果当前值比最左值小，则说明该盛水区间仍然没到最右点
                int count = 1;
                //将所有比当前值小的区间填满，并将水平区间的个数插入栈中
                while(currentVal > s.peek()){
                    count += index.peek();
                    result += (currentVal - s.pop()) * index.pop();
                }
                s.push(currentVal);
                index.push(count);
            }
        }
        return result;
    }

    public static int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int leftMax=0, rightMax=0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(height[left], leftMax);
                result += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(height[right], rightMax);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        int a = trap2(height);
        System.out.println(a);
    }
}
