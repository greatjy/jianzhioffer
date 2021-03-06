package com.baidu.char3;

public class LastKNode
{
    public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode lastK = lastKListNode(head,5);
		System.out.println(lastK.val);
	}

	private static ListNode lastKListNode(ListNode head, int k)
	{
		if(k<1)
			return null;
		if(head == null)
		{
			return null;
		}
		ListNode A = head;
		ListNode B = head;
		for(int i=0;i<k-1;i++)
		{
			A = A.next;
		}
		if(A == null)
		{
			return null;
		}
		while(A.next != null)
		{
			A = A.next;
			B = B.next;
		}
		return B;

	}
}
