package com.baidu.char3;

import javax.xml.soap.Node;

class ListNode
{
    int val;
    ListNode next;
    public ListNode(int val)
    {
    	this.val = val;
    }
}
public class DeleteNode
{
    public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		deleteNode(head,3);
		while(head.next != null)
		{
			
		}
	}
    public static void deleteNode(ListNode head,int d)
    {
    	if(head == null)
    		return ;
    	ListNode root = new ListNode(-1);
    	root.next = head;
    	ListNode current = root;
    	while(current.next != null)
    	{
    		if(current.next.val != d)
    		{
    			current = current.next;
    		}
    		else
    		{
    			current.next = current.next.next;
    		}
    	}
    }
}
