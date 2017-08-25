package linkedlist;

import java.util.HashSet;
import java.util.Stack;

public class StackUtil {
	
		class Node{
			int data;
			Node next;
			public Node(int data){
				this.data = data;
			}
		}
		
		
		
		
		
		
		
		
		//1.删除单链表中的指定结点
	    public static void deleteNode(Node head,Node node)  
	    {  
	    			//删除尾节点，采用顺序查找找到尾节点的前一节点
	    	         if(node.next==null){
	    	             while(head.next!=node){
	    	                 head=head.next;
	    	             }
	    	             head.next=null;
	    	         }
	    	         //要删除的节点是头结点
	    	         else if(head==node){
	    	             head=null;
	    	         }
	    	         //要删除的节点是中间普通节点
	    	         else{
	    	        	 	 Node q = node.next;
	    	             node.data=q.data;
	    	             node.next=q.next;
	    	         }
	          
	    }  
	    
	    //2.单链表中删除指定数值的节点方法一：利用栈
	    public Node removeValue1(Node head,int num){
	    		Stack<Node> stack = new Stack<Node>();
	    		while(head != null){
	    			if(head.data != num){
	    				stack.push(head);
	    			}
	    			head = head.next;
	    		}
	    		while(!stack.isEmpty()){
	    			stack.peek().next = head;
	    			head = stack.pop();
	    		}
	    		return head;
	    }
	    
	    //3.单链表中删除指定数值的节点方法二：不利用栈
	    public Node removeValue2(Node head,int num){
	    		while(head != null){
	    			if(head.data != num){
	    				break;
	    			}
	    			head = head.next;
	    		}
	    		Node pre = head;
	    		Node cur = head;
	    		while(cur != null){
	    			if(cur.data == num){
	    				pre.next = cur.next;
	    			}else{
	    				pre = cur;
	    			}
	    			cur = cur.next;
	    		}
	    		return head;
	    }
	    
	    //4.删除单链表中数值重复出现的节点
	    public void deleteDuplication(Node head)  
	    {  
	    	   if(head == null){
	    		   return;
	    	   }
	    	   HashSet<Integer> set= new HashSet<Integer>();
	    	   Node pre = head;
	    	   Node cur = head.next;
	    	   set.add(head.data);
	    	   while(cur != null){
	    		   if(set.contains(cur.data)){
	    			   pre.next = cur.next;
	    		   }else{
	    			   set.add(cur.data);
	    			   pre = cur;
	    		   }
	    		   cur = cur.next;
	    	   }
	    }  
	    
	    //5.两个单链表生成相加链表:方法一
	    public  Node addList1(Node head1,Node head2)  
	    {  
	        head1=reverseList(head1);  
	        head2=reverseList(head2);  
	          
	        int n1=0;  
	        int n2=0;  
	        int n=0;  
	        int ca=0;   //进位  
	          
	        Node node=null;  
	        Node pnode=null;  
	        while(head1!=null||head2!=null)  
	        {  
	            n1=head1==null?0:head1.data;  
	            n2=head2==null?0:head2.data;  
	            head1=head1.next;  
	            head2=head2.next;  
	            n=n1+n2+ca;  
	            node=new Node(n%10);  
	            node.next=pnode;  
	            pnode=node;  
	            ca=n/10;  
	        }  
	          
	        if(n>=10)  
	        {  
	            node=new Node(n/10);  
	            node.next=pnode;  
	        }  
	        reverseList(head1);
	        reverseList(head2);
	          
	        return node;  
	    }  
	    //实现链表的逆序 :链表的反转
	    public static Node reverseList(Node head)  
	    {  
	        Node pre=null;  
	        Node next=null;  
	        while(head!=null)  
	        {  
	            next=head.next;  
	            head.next=pre;  
	            pre=head;  
	            head=next;  
	        }  
	        return pre;  
	    }  
	    
	  //6.两个单链表生成相加链表:
	    public  Node addList2(Node head1,Node head2)  
	    {   
	        Stack<Integer> stack1 = new Stack<Integer>();
	        Stack<Integer> stack2 = new Stack<Integer>();
	        while(head1 != null){
	        		stack1.push(head1.data);
	        		head1 = head1.next;
	        }
	        while(head2 != null){
	        		stack2.push(head2.data);
	        		head2 = head2.next;
	        }
	        int n1=0;  //链表1的数值
	        int n2=0;  //链表2的数值
	        int n=0;  //n1+n2+ca
	        int ca=0;   //进位  
	          
	        Node node=null; //当前节点 
	        Node pnode=null;  //当前节点的前驱节点
	        while(!stack1.isEmpty()||!stack2.isEmpty())  
	        {  
	            n1 = stack1.isEmpty() ? 0 : stack1.pop();
	            n2 = stack2.isEmpty() ? 0 : stack2.pop();
	            n=n1+n2+ca;  
	            node=new Node(n%10);  
	            node.next=pnode;  
	            pnode=node;  
	            ca=n/10;  
	        }  
	          
	        if(ca == 1)  
	        {  
	        		pnode = node;
	            node=new Node(n/10);  
	            node.next=pnode;  
	        }  
	          
	        return node;  
	    }  
	    
	    //7.判断一个单链表是否为回文结构
	    public boolean isPalindrome1(Node head){  
	         if(head==null){  
	             return false;  
	         }  
	         Stack<Node> stack=new Stack<Node>();  
	         Node cur=head;  
	         while(cur!=null){//记住这个地方不是cur.next不然最后一个节点没有压入栈  
	             stack.push(cur);  
	             cur=cur.next;  
	         }  
	         while(head.next!=null){  
	             if(head.data!=stack.pop().data){  
	                 return false;  
	             }  
	             head=head.next;  
	         }  
	         return true;  
	     }  
	    
	    // 8.删除单链表的倒数第k个节点
	    public static Node removeLastKthNode(Node head, int k) {
	        if (k <= 0 || head == null)
	            return head;
	        Node p = head;
	        for (int i = 0; i < k; i++) {
	            if (p.next != null)
	                p = p.next;
	            else
	                return head;
	        }
	        Node q = head;
	        while (p.next != null) {
	            p = p.next;
	            q = q.next;
	        }
	        q.next = q.next.next;
	        return head;
	    }

	    // 9.删除单链表的倒数第k个节点(方法二)
	    public static Node removeLastKthNode2(Node
	    head, int k) {
	        if(k <= 0 ||head == null)return head;
	        Node p = head;
	        while(p!=null){
	            p = p.next;
	            k--;
	        }
	        if(k==0)return head.next;
	        if(k<0){
	        	Node q = head;
	            while(++k!=0){ //这里注意，先自加，在判断
	                q=q.next;
	            }
	            q.next=q.next.next;
	        }
	        return head;
	    }
	 
}
