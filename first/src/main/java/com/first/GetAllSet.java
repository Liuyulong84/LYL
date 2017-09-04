package com.first;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by $lyl on 2017/9/3.
 */


//求一个集合的所有子集。输入是一个整数数组所代表的集合，输出是一个list，list的每一个元素是集合的一个子集。
//
//        List<List<Integer>> getAllSet(int[] arr) {
//        // code here
//        }

public class GetAllSet {

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        getAllSet(arr);
    }

    private static void getAllSet(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        int n = a.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> bean = new ArrayList<>();
            String setStr = Integer.toBinaryString(i);
            int m = n - setStr.length();
            for (int j = 0; j < setStr.length(); j++) {
                if (setStr.charAt(j) == '1')
                    bean.add(a[m + j]);
            }
            result.add(bean);
        }
        System.out.print(result);
    }

}
