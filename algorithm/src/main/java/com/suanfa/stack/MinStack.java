package com.suanfa.stack;

import java.util.Stack;

//设计含最小函数min()的栈，要求min、push、pop、的时间复杂度都是O(1)。min方法的作用是：就能返回是栈中的最小值
public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();     //定义用来存储数据的栈
    Stack<Integer> minStack = new Stack<Integer>();  //定义用来存储最小数据的栈
    
    /**
     * 添加数据，首先是往stack栈中添加
     * 如果最小栈minStack为空，或者栈顶的元素比新添加的元素要大，则将新元素也要添加的辅助栈中
     * @param node
     */
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty() || ((int)minStack.peek()) >= node){
            minStack.push(node);
        }
    }
    
    /**
     * 如果stack空，直接返回
     * 如果stack不为空，得到栈顶元素，同时将栈顶元素弹出
     * 如果最小栈的栈顶元素与stack弹出的元素相等，那么最小栈也要将其弹出
     */
    public void pop() {
        if(stack.isEmpty())
            return;
        int node = (int)stack.peek();
        stack.pop();
        if((int)minStack.peek() == node){
            minStack.pop();
        }
    }
    
    
    /**
     * 查看栈的最小元素
     * @return
     */
    public int min() {
        return (int)minStack.peek();
    }
}
