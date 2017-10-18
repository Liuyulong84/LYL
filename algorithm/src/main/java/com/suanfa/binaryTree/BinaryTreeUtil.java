package com.suanfa.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class BinaryTreeUtil {
	
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

    }

    //分层打印 二叉树


	
	//1.分层遍历二叉树迭代 
	public static void levelTraversal(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.push(root);  
  
        while (!queue.isEmpty()) {  
            TreeNode cur = queue.removeFirst();  
            System.out.print(cur.val + " ");  
            if (cur.left != null) {  
                queue.add(cur.left);  
            }  
            if (cur.right != null) {  
                queue.add(cur.right);  
            }  
        }  
    }

    public ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);
        TreeNode last = root;
        TreeNode nLast = root;
        queue.add(root);
        while (! queue.isEmpty()) {
            TreeNode out = queue.poll();
            System.out.print(out.val + " ");
            list.add(out.val);
            if(out.left !=null){
                queue.add(out.left);
                nLast = out.left;
            }
            if(out.right !=null){
                queue.add(out.right);
                nLast = out.right;
            }
            if(out == last){
                last = nLast;
                System.out.println("");
            }
        }
        return  list;
    }
	
	//分层遍历的应用1：求二叉树中的节点个数
	public static int getNodeNum(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
        int count = 1;  
        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
          
        while(!queue.isEmpty()){  
            TreeNode cur = queue.remove();      // 从队头位置移除  
            if(cur.left != null){           // 如果有左孩子，加到队尾  
                queue.add(cur.left);  
                count++;  
            }  
            if(cur.right != null){      // 如果有右孩子，加到队尾  
                queue.add(cur.right);  
                count++;  
            }  
        }  
          
        return count;  
    }  
	
	//分层遍历的应用2:求二叉树的深度
	public static int getDepth(TreeNode root) {  
        if(root == null){  
            return 0;  
        }  
          
        int depth = 0;                          // 深度  
        int currentLevelNodes = 1;      // 当前Level，node的数量  
        int nextLevelNodes = 0;         // 下一层Level，node的数量  
          
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  
        queue.add(root);  
          
        while( !queue.isEmpty() ){  
            TreeNode cur = queue.remove();      // 从队头位置移除  
            currentLevelNodes--;            // 减少当前Level node的数量  
            if(cur.left != null){               // 如果有左孩子，加到队尾  
                queue.add(cur.left);  
                nextLevelNodes++;           // 并增加下一层Level node的数量  
            }  
            if(cur.right != null){          // 如果有右孩子，加到队尾  
                queue.add(cur.right);  
                nextLevelNodes++;  
            }  
              
            if(currentLevelNodes == 0){ // 说明已经遍历完当前层的所有节点  
                depth++;                       // 增加高度  
                currentLevelNodes = nextLevelNodes;     // 初始化下一层的遍历  
                nextLevelNodes = 0;  
            }  
        }  
          
        return depth;  
    }  
	
	//分层遍历的应用3:求二叉树第K层的节点个数
		public static int getNodeNumKthLevel(TreeNode root, int k){  
	        if(root == null){  
	            return 0;  
	        }  
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();  
	        queue.add(root);  
	          
	        int i = 1;  
	        int currentLevelNodes = 1;      // 当前Level，node的数量  
	        int nextLevelNodes = 0;         // 下一层Level，node的数量  
	          
	        while( !queue.isEmpty() && i<k){  
	            TreeNode cur = queue.remove();      // 从队头位置移除  
	            currentLevelNodes--;            // 减少当前Level node的数量  
	            if(cur.left != null){               // 如果有左孩子，加到队尾  
	                queue.add(cur.left);  
	                nextLevelNodes++;           // 并增加下一层Level node的数量  
	            }  
	            if(cur.right != null){          // 如果有右孩子，加到队尾  
	                queue.add(cur.right);  
	                nextLevelNodes++;  
	            }  
	              
	            if(currentLevelNodes == 0){ // 说明已经遍历完当前层的所有节点  
	                currentLevelNodes = nextLevelNodes;     // 初始化下一层的遍历  
	                nextLevelNodes = 0;  
	                i++;            // 进入到下一层  
	            }  
	        }  
	          
	        return currentLevelNodes;  
	    }  
		
	
	//2.前序遍历（递归）
	public static void preorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        System.out.print(root.val + " ");  
        preorderTraversalRec(root.left);  
        preorderTraversalRec(root.right);  
    }  
	
	//2.前序遍历（迭代）
	public static void preorderTraversal(TreeNode root) {  
        if(root == null){  
            return;  
        }  
          
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        stack.push(root);  
          
        while( !stack.isEmpty() ){  
            TreeNode cur = stack.pop();     // 出栈栈顶元素  
            System.out.print(cur.val + " ");  
              
            // 关键点：要先压入右孩子，再压入左孩子，这样在出栈时会先打印左孩子再打印右孩子  
            if(cur.right != null){  
                stack.push(cur.right);  
            }  
            if(cur.left != null){  
                stack.push(cur.left);  
            }  
        }  
    }  
	
	//3.中序遍历（递归）
	public static void inorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        inorderTraversalRec(root.left);  
        System.out.print(root.val + " ");  
        inorderTraversalRec(root.right);  
    }  
	//3.中序遍历（迭代）
	public static void inorderTraversal(TreeNode root){  
        if(root == null){  
            return;  
        }  
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        TreeNode cur = root;  
          
        while( true ){  
            while(cur != null){     // 先添加一个非空节点所有的左孩子到栈  
                stack.push(cur);  
                cur = cur.left;  
            }  
              
            if(stack.isEmpty()){  
                break;  
            }  
                  
            // 因为此时已经没有左孩子了，所以输出栈顶元素  
            cur = stack.pop();  
            System.out.print(cur.val + " ");  
            cur = cur.right;    // 准备处理右子树  
        }  
    }  
	
	//4.后序遍历（递归）
	public static void postorderTraversalRec(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
        postorderTraversalRec(root.left);  
        postorderTraversalRec(root.right);  
        System.out.print(root.val + " ");  
    } 
	//4.后序遍历（迭代）
	public static void postorderTraversal(TreeNode root) {  
        if (root == null) {  
            return;  
        }  
          
        Stack<TreeNode> s = new Stack<TreeNode>();      // 第一个stack用于添加node和它的左右孩子  
        Stack<TreeNode> output = new Stack<TreeNode>();// 第二个stack用于翻转第一个stack输出  
          
        s.push(root);  
        while( !s.isEmpty() ){      // 确保所有元素都被翻转转移到第二个stack  
            TreeNode cur = s.pop(); // 把栈顶元素添加到第二个stack  
            output.push(cur);         
              
            if(cur.left != null){       // 把栈顶元素的左孩子和右孩子分别添加入第一个stack  
                s.push(cur.left);  
            }  
            if(cur.right != null){  
                s.push(cur.right);  
            }  
        }  
          
        while( !output.isEmpty() ){ // 遍历输出第二个stack，即为后序遍历  
            System.out.print(output.pop().val + " ");  
        }  
    }


    //从根节点到目标节点 的 path

    public List<Integer> getPath(TreeNode root, int val) {
        preorder(root, val);
        return result;
    }

    List<Integer> result;
    LinkedList<Integer> path = new LinkedList<>();

    void preorder(TreeNode root, int key) {
        if (root == null || result != null) {
            return;
        }

        if (root.val == key) {
            path.add(root.val);
            result = path;
            return;
        } else {
            path.add(root.val);
            preorder(root.left, key);
            preorder(root.right, key);
            path.removeLast();
        }
    }




}
