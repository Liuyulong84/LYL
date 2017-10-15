package com.first;


// 题目描述
//        给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大,原来顺序不变。
//        输入描述:
//        输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 1000。第二行是希望去掉的数字数量cnt 1 ≤ cnt < length(number)。
//        输出描述:
//        输出保留下来的结果。
//        示例1
//        输入
//
//        325
//        1
//        输出

//        35

/**
 * Created by $lyl on 2017/9/26.
 */

public class DeleteSomeToMaxSum {

    public static void main(String[] args) {
        int result = max(913232234, 3);
        System.out.println(result);
        System.out.println("lyl");
        method_lyl(913232234, 3);
    }



    static int max(int n, int count) {
        String num = "" + n;
        if (count >= num.length()) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();

        int t = 0;
        for (int i = count; i < num.length(); i++) {
            t = findMax(num, t, i);
            sb.append(num.charAt(t));
            System.out.println(sb);
            t++;
        }

        return Integer.parseInt(sb.toString());
    }

    static int findMax(String s, int b, int e) {

        System.out.println(b + "_" + e);
        int t = b;
        for (int i = b + 1; i <= e; i++) {
            if (s.charAt(t) < s.charAt(i)) {
                t = i;
            }
        }
        return t;
    }

    static void method_lyl(int n, int count) {
        String num = n+ "";
        while (count >0){
            for (int i = 0; i < num.length()-1; i++) {
                if (num.charAt(i) < num.charAt(i+1) ){
                    num = num.substring(0,i) + num.substring(i+1);
                    break;
                }
            }
            count --;
        }
        System.out.println(num);
    }

}
