package com.baidu.char2;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static void main(String[] args)
	{
		StringBuffer sBuffer = new StringBuffer("we are happy");
		//System.out.println(replaceSpace(sBuffer));
		ListNode head = new ListNode(5);
		head.next = new ListNode(81);
		head.next.next = new ListNode(61);
		head.next.next.next = new ListNode(95);
		ArrayList<Integer> aList = printListFromTailToHead(head);
		for(int i:aList)
		{
			//System.out.println(i);
		}
		System.out.println(NumberOf1(0x80000000));
		
	}
	private static Stack<ListNode> stack = new Stack<>();
    private static ArrayList<Integer> al = new ArrayList<Integer>();
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode)
    {
        if(listNode == null)
            return al;
        ListNode current = listNode;
        while(current != null)
        {
            stack.push(current);
            current = current.next;
        }
        while(!stack.isEmpty())
        {
            int val = stack.pop().val;
            //System.out.println(val);
            al.add(val);
        }
        return al;
    }
    public static int NumberOf1(int n) 
    {
    	  int count = 0;
    	  int flag = 1;
          while(flag != 0)
         {
             int bit = n&flag;
             
             if(bit != 0)
             {
                 count++;
             }
             flag<<=1;
         }
		return count;
    }
}