package com.first;

/**
 * Created by lyl on 2017/1/23.
 *
 *  套用经典 dp
 */

public class LongestSubSequence {


    public static String lcst(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < str2.length; j++) {
            if (str1[0] == str2[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    static int process(String s) {
        int strLen = s.length();
        if (strLen <= 1) {
            return strLen;
        }

        int maxLen = 1;
        int curLen = 1;
        s = s.toLowerCase();
        for (int i = 1; i < strLen; i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                curLen++;
            } else {
                if (curLen > maxLen) {
                    maxLen = curLen;
                }

                curLen = 1;
            }
        }
        int result = maxLen > curLen ? maxLen : curLen;
        System.out.println("pwg->    " + result );

        return maxLen;
    }


    public static void main(String[] args) {

        String given = "aexkifkFghIjKsopt";
        String pwg = "aaaaabc";
        String zidian = "abcdefghijklmnopqrstuvwxyz";

        String s1 = given.toLowerCase();

        process(pwg);

        System.out.println("---------------------------------");
        String result = lcst(s1, zidian);
        System.out.println("result->    "+ result );
        System.out.println("length->    " + result.length());
    }

}

