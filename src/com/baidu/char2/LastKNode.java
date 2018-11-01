package com.baidu.char2;

import java.awt.event.MouseWheelEvent;
import java.util.ServiceConfigurationError;

public class LastKNode
{
    public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next =new ListNode(3);		
		int k = 3;
		System.out.println(findKElem(head, k).val);
	}
    public static ListNode findKElem(ListNode head,int k)
    {
    	if(k<1)
    		return null;
    	if(head == null)
    		return null;
    	ListNode first = head;
    	ListNode second = head;
    	for(int i=0;i<k-1;i++)
    	{
    		first = first.next;
    	}
    	if(first == null)
    	{
    		return null;
    	}
    	while(first.next!=null)
    	{
    		first = first.next;
    		second = second.next;
    	}
    	return second;
    }
}
