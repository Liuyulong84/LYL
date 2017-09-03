package com.first;

/**
 * Created by $lyl on 2017/9/3.
 */


//求两个字符串代表的正整数的和，数字是合法的，长度不限。
//        如 输入是 "11111"  和 "22222" ， 输出是 "33333"
//
//        String addStr(String s1, String s2) {
//        // code here
//        }
public class AddBigData {

    private static String addString(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;
        int k = Math.max(i, j);
        int[] result = new int[k + 1];
        int sum = 0, jinwei = 0;
        while (k>= 0) {
            int d1 = i >= 0 ? (s1.charAt(i) - '0') : 0;
            int d2 = j >= 0 ? (s2.charAt(j) - '0') : 0;
            sum = d1 + d2 + jinwei;
            result[k] = sum % 10;
            jinwei = sum / 10;
            k--;
            i--;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        if (jinwei != 0) sb.append(jinwei);
        for (int it : result) {
            sb.append(it);
        }
        return sb.toString();
    }

}

