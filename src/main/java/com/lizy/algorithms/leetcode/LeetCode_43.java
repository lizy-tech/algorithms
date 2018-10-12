package com.lizy.algorithms.leetcode;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-10-10 9:01
 */
public class LeetCode_43 {

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1-1; i >=0; i--) {
            for (int j = len2-1; j >=0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : res) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multiply2(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2-1];
        for (int i = len1-1; i >=0; i--) {
            for (int j = len2-1; j >=0; j--) {
                res[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                /*int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p1] += sum / 10;
                res[p2] = sum % 10;*/
            }
        }

        for (int i = res.length-1; i > 0; i--) {
            int num = res[i];
            res[i] = num%10;
            res[i - 1] += num / 10;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i< res.length; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        String res = multiply2(num1, num2);
        System.out.println(res);

    }

    
}
