package com.first;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by $lyl on 2017/10/18.
 */

public class FindPath {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        getPath(root,6);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    public static List<Integer> getPath(TreeNode root, int val) {
        preorder(root, val);
        return result;
    }

    static List<Integer> result;
    static LinkedList<Integer> path = new LinkedList<>();

    static void preorder(TreeNode root, int key) {
        if (root == null || result != null) {
            return;
        }

        if (root.val == key) {
            path.add(root.val);
            result = (List<Integer>) path.clone();

            return;
        } else {
            path.add(root.val);
            preorder(root.left, key);
            preorder(root.right, key);
            path.removeLast();
        }
    }
}
