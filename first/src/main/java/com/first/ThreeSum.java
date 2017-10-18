package com.first;

import java.util.Arrays;

/**
 * Created by $lyl on 2017/9/7.
 */

public class ThreeSum {



    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, -1};
        System.out.println(process(16, arr));
        int x =9;
        System.out.println(x & 3);
        int y = 8 ;
        System.out.println( y & 3);
    }


    public static boolean process(int sum, int[] a) {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            boolean found = find2Sum(sum - a[i], a, i+1);
            if (found) {
                return true;
            }
        }
        return false;
    }

    public static boolean find2Sum(int v, int[] a ,int start) {
        int l = start;
        int r = a.length - 1;
        while (l < r) {
            if (a[l] + a[r] < v)
                l++;
            else if (a[l] + a[r] > v)
                r--;
            else {
                return true;
            }
        }
        return false;
    }
}
