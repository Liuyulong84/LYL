package com.first;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by $lyl on 2017/3/10.
 */

public class SlideWindow {

    public static class Node {
        public int v1;
        public int v2;
        public Node next = null;

        public Node(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public void setNext(Node next) {
            this.next = next;
            if(next.v2 >this.v2){
                this.v2 = next.v2;
            }

        }


        private void printNode() {
            System.out.println("{" + this.v1 + "," + this.v2 + "}");
        }
    }

    public static void main(String[] args) {
        ArrayList<Node> list = new ArrayList<Node>();
        int[][] arr = {{1, 3}, {2, 3}, {3, 5},{1,4}, {6, 10}, {10, 11},{100,102}};

        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i][0], arr[i][1]);
            boolean needAdd = true;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).v2 >= node.v1 && list.get(j).v1 <= node.v1) {
                    needAdd = false;
                    list.get(j).setNext(node);
                    break;
                }
            }
            if (needAdd) {
                list.add(node);
            }
        }

        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }

        System.out.println("-----------------------");
        System.out.println("{");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).printNode();
        }
        System.out.println("}");

        System.out.println("-----------------------");

    }


}
