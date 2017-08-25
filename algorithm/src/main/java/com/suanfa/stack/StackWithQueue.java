package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

    private static Queue<Object> queue1=new LinkedList<Object>();
    private static Queue<Object> queue2=new LinkedList<Object>();
    
    /*
     * 向队列中执行入栈操作时，把元素添加到非空的队列中
     */
    public static void push(Object item){
        if(!queue1.isEmpty())
            queue1.offer(item);
        else
            queue2.offer(item);
        System.out.println("入栈元素为："+item);
    }
    
    public static void pop(){
        if(!isEmpty()){
            if(queue1.isEmpty()){
                while(queue2.size()>1){
                    queue1.offer(queue2.poll());
                }
                System.out.println("出栈元素为："+queue2.poll());
            }else{
                while(queue1.size()>1){
                    queue2.offer(queue1.poll());
                }
                System.out.println("出栈元素为："+queue1.poll());
            }
        }
        else
            throw new RuntimeException("栈为空，无法执行出栈操作");
    }
    
    /*
     * 检查栈是否为空
     */
    private static boolean isEmpty(){
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}
