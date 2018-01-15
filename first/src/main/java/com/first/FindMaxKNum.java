package com.first;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by $lyl on 2017/3/17.
 */

public class FindMaxKNum {


    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] topk(int[] nums, int k) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) {
                    return 1;
                } else if(o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k, comparator);

        for (int i : nums) {
            minheap.add(i);
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = minheap.poll();
        }
        return result;
    }

    private static int countResult(int[] arr){
        int before = arr[0] ;
        int beforeCount = 0, nextCount = 0;
        for (int item: arr){
            if ( item == before){
                nextCount ++ ;
            }else {
                beforeCount = beforeCount > nextCount ? beforeCount :nextCount;
                nextCount = 0 ;
                before = item;
                nextCount ++;
            }
        }
        return Math.max(beforeCount,nextCount);
    }


    public static void main(String[] args) {
        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };

        int [] gt = {1,5,3,4,2};
        int gtk = 2 ;

        //printArray(topk(arr,3));
        //printArray(topk(gt,gtk));
        arr = new int[]{4, 4, 4, 4, 4, 6, 7,7,7,7,7,7,7,7,7,7,7,7,7,7, 8, 9, 3, 3};
        System.out.println(countResult(arr));

    }
}
