package com.first;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by $lyl on 2017/3/30.
 */

public class MaxDiff {

    public static int MaxDiff(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        //System.out.print(MaxDiff(arr));

        System.out.println(addString("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                                     "9999999999999999999999999999999999999999999999999999999999933333333333333333333333333333333333333333333333333"));
    }



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
