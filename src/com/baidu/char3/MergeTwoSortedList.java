package com.baidu.char3;

public class MergeTwoSortedList 
{
    public static void main(String[] args) 
    {
	    ListNode head1 = new ListNode(1);
	    head1.next = new ListNode(3);
	    head1.next.next = new ListNode(5);
	    ListNode head2 = new ListNode(1);
	    head2.next = new ListNode(3);
	    head2.next.next = new ListNode(5);
	    ListNode ans = mergeTwo(head1,head2);
	    //ListNode ans = head1;
	    while(ans != null)
	    {
	    	System.out.println(ans.val);
	    	ans = ans.next;
	    }
	}

	private static ListNode mergeTwo(ListNode list1, ListNode list2) {
		// TODO Auto-generated method stub
		if(list1 == null )
			return list2;
		if(list2 == null)
			return list1;
		ListNode p1 = list1;
		ListNode p2 = list2;
		ListNode ans = null;
		ListNode cur = null;
		while(p1 != null && p2 != null)
		{
			if(p1.val < p2.val)
			{
				if(ans == null)
				{
					ans = p1;
					cur = ans;
				}
				else
				{
					cur.next = new ListNode(p1.val);//注意移动ans
					cur = cur.next;
				}
				p1 = p1.next;
			}
			else
			{
				if (ans == null)
				{
				    ans = p2;	
				    cur = ans;
				}
				else
				{
					cur.next = new ListNode(p2.val);
					cur = cur.next;
				}
				p2 = p2.next;
			}
			//cur = cur.next;
		}
		if(p1 != null)
		{	
			cur.next = p1;	
		}
		if(p2 != null)
		{
			cur.next = p2;	
		}
		return ans;
	}
}
