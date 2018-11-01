package com.baidu.char3;

public class DeleteDupLication
{
    public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);
		ListNode root = deleteDuplicate(head);
		while(root != null)
		{
			System.out.println(root.val);
			root = root.next;
		}
	}

	private static ListNode deleteDuplicate(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		ListNode preNode = null;
		ListNode currNode = head;
		while(currNode != null)
		{
			ListNode pnext = currNode.next;
			boolean needDelete = false;
			if(pnext != null && pnext.val == currNode.val)
			{
				needDelete = true;
			}
			if(!needDelete)
			{
				preNode = currNode;
				currNode = currNode.next;
			}
			else
			{
				int value = currNode.val;
				ListNode toBeDelete = currNode;
				while(toBeDelete != null && toBeDelete.val == value)
				{
					pnext = toBeDelete.next;
					toBeDelete = toBeDelete.next;
				}
				if(preNode == null)
				{
					head = pnext;
				}
				else
				{
					preNode.next = pnext;
				}
				currNode = pnext; 
			}
		}
		return head;
	}
}
