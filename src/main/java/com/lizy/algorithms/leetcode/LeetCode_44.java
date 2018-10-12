package com.lizy.algorithms.leetcode;

import java.util.Scanner;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-10-11 9:50
 */
public class LeetCode_44 {
    public static boolean isMatch(String s, String p) {
        if (s.length() > 0 && p.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            if (p.length() == 0 || (p.length() == 1 && "*".equals(p))) {
                return true;
            } else if (p.charAt(0) == '*') {
                return isMatch(s, p.substring(1));
            } else {
                return false;
            }

        }
        while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*')) {
            if (p.charAt(0) == '*') {
                return isMatch(s.substring(1), p) || isMatch(s.substring(1), p.substring(1)) || isMatch(s, p.substring(1));
            }
            if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        return false;
    }

    public static boolean isMatch2(String s, String p) {
        int sIndex = 0, pIndex = 0, match = 0, starIdx = -1;
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))) {
                sIndex++;
                pIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIdx = pIndex;
                match = sIndex;
                pIndex++;
            } else if (starIdx != -1) {
                pIndex = starIdx + 1;
                match++;
                sIndex = match;
            } else {
                return false;
            }
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        return pIndex == p.length();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.next();
            String p = in.next();
            System.out.println("s=" + s + ",p=" + p);
            boolean res = isMatch2(s, p);
            System.out.println(res);
        }

    }
}
