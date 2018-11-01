package com.baidu.char2;

import java.util.Stack;

public class PrintReverseList
{
    public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		printReversly(head);
	}
    public static void printReversly(ListNode head)
    {
         Stack<ListNode> stack = new Stack<>();
         ListNode current = head;
         while(current != null)
         {
        	 stack.push(current);
        	 current = current.next;
         }
         while(!stack.isEmpty())
         {
        	 ListNode top = stack.peek();
        	 System.out.println(top.val);
        	 stack.pop();
         }
    }
}
class ListNode
{
	 int val;
	 ListNode next = null;
	 ListNode(int val) 
	 {
		 this.val = val;
	 }
}