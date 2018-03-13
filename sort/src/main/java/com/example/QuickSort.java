package com.example;

/**
 * Created by $lyl on 2017/5/19.
 */

//找出第三大的数字，就是 pivotPos == 3 的时候
public class QuickSort {
    //一次划分
    public static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left];
        int pivotPointer = left;

        while (left < right) {
            while (left < right && arr[right] >= pivotKey)
                right--;
            while (left < right && arr[left] <= pivotKey)
                left++;
            swap(arr, left, right); //把大的交换到右边，把小的交换到左边。
        }
        swap(arr, pivotPointer, left); //最后把pivot交换到中间
        return left;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        sort(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}