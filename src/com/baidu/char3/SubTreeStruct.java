package com.baidu.char3;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode
{
    double val;
    TreeNode left;
    TreeNode right;
    public TreeNode(double val) {
		this.val = val;
	}
}
public class SubTreeStruct 
{
    public static void main(String[] args) {
	    TreeNode head1 = new TreeNode(8);
	    head1.left = new TreeNode(8);
	    head1.right = new TreeNode(7);
	    head1.left.left = new TreeNode(9);
	    head1.left.right = new TreeNode(2);
	    head1.left.right.left = new TreeNode(4);
	    head1.left.right.right = new TreeNode(7);
	    bianlibylevel(head1);
	    
	    TreeNode head2 = new TreeNode(8);
	    head2.left = new TreeNode(9);
	    head2.right = new TreeNode(2);
	    
	    System.out.println(isSubTree(head1, head2));
	}
    public static boolean isSubTree(TreeNode A,TreeNode B)
    {
    	//递归 从A的每一个节点开始 逐个匹配
    	if(A == null || B == null)
    	{
    		return false;
    	}
    	boolean flag = false;
    	if(A != null && B!= null)
    	{
    		if(A.val == B.val)
    		{
    			flag = isSame(A, B);
    		}
    		if(!flag)
    		{
    			flag = isSame(A.left, B);
    		}
    		if(!flag)
    		{
    			flag = isSame(A.right, B);
    		}
    	}
		return flag;
    	
    }
    public static boolean isSame(TreeNode A,TreeNode B)
    {
    	if(B == null )
    	{
    		return true;
    	}
    	if(A == null)
    	{
    		return false;
    	}
    	if(!isEql(A.val, B.val))
    	{
    		return false;
    	}
    	else
    	{
    		return isSame(A.left, B.left) && isSame(A.right, B.right);
    	}
    }
    public static boolean isEql(double a, double b)
    {
    	return Math.abs(a-b)<1e-5;
    }
    public static void bianlibylevel(TreeNode head)
    {
    	Queue<TreeNode> queue = new LinkedList<>();
    	if(head != null)
    	{
    		queue.offer(head);
    	}
    	while(!queue.isEmpty())
    	{
    		int size = queue.size();
    		for(int i=0;i<size;i++)
    		{
    		TreeNode fNode = queue.poll();
    		System.out.print(fNode.val+"\t");
    		if(fNode.left != null)
    		{
    			queue.offer(fNode.left);
    		}
    		if(fNode.right != null)
    		{
    			queue.offer(fNode.right);
    		}
    		}
    		System.out.println();
    	}
    }
    
}
