package com.lizy.algorithms.leetcode;

/**
 * @author lizy@19pay.com.cn
 * @date 2019-5-20 15:23
 */
public class LeetCode_58 {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length()==0) {
            return 0;
        }
        int index = 0;
        while (s.length()>0 && s.charAt(s.length()-1) == ' '){
            s = s.substring(0, s.length() - 1);
        }
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }else {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "   ";
        int res = lengthOfLastWord(s);
        System.out.println(res);
    }
}
