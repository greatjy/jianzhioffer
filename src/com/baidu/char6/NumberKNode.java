package com.baidu.char6;import java.util.Currency;
import java.util.Stack;

import javax.swing.RootPaneContainer;

class TreeNode
{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int val)
	{
		this.val = val;
	}
}
public class NumberKNode
{
    public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
        //System.out.println(myKthNode(root, 6));
		zhong(root);
	}

	public static TreeNode numberKNode(TreeNode root, int k)
	{
		if(root == null || k < 0)
			return null;
		return kthNode(root,k);
	}
    public static int index = 0;
	public static TreeNode kthNode(TreeNode root, int k)
	{
        if(root != null){ //中序遍历寻找第k个
		 TreeNode node = kthNode(root.left,k);
		// System.out.println(node.val+" "+"left");
        if(node != null)
        {
        	System.out.println(node.val+" left");
			                return node;
        }
       
	    if(index == k)
		    return root;
	    node = kthNode(root.right,k);
        if(node != null)
        {	System.out.println(node.val+" right");
        	return node;
        }
        }
			        return null;
	}
	
	//思路很顺 但是就是不对啊
    public static int sum = 0;
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot != null){
            TreeNode node = KthNode(pRoot.left,k);
            if(node != null){
            	System.out.println(node.val+" left");
                return node;
            }
            System.out.println(sum+"sum");
            if(++sum == k){
                return pRoot;
            }
            node = KthNode(pRoot.right,k);
            if(node != null){
            	System.out.println(node.val+"right");
                return node;
            }
        }
        return null;
    }
    
    public static int i = 0;
    public static TreeNode zhongxu(TreeNode root,int k)
    {
    	if(root == null)
    		return null;
    	TreeNode node = zhongxu(root.left, k);
    	if(node != null)
    	{
    		System.out.println(node.val+"leftNode");
    		return node;
    	}
    	//System.out.println(root.val);
    	i++;
    	System.out.println(i+"i");
    	if(i == k)
    		return root;
    		//System.out.println(root.val);
    	node = zhongxu(root.right,k);
    	if(node != null)
    	{
    		System.out.println(node.val+"rightNode");
    		return node;
    	}
    	return  null;
    }

	public static TreeNode myKthNode(TreeNode root, int k)
	{
		if (root == null || k == 0)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count = 0;
		TreeNode node = root;
		do
		{
			if (node != null)
			{
				stack.push(node);
				System.out.print("push[");
				for(TreeNode node1 : stack)
				{
					System.out.print(node1.val+" ");
				}
				System.out.print("]");
				node = node.left;
			} else
			{
				node = stack.pop();
				System.out.print("pop[");
				for(TreeNode node1 : stack)
				{
					System.out.print(node1.val+" ");
				}
				System.out.print("]");
				count++;
				if (count == k)
					return node;
				node = node.right;
			}
		} while (node != null || !stack.isEmpty());
		return null;
	}
	
	public static void zhong(TreeNode root)
	{
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		//stack.push(root);
		TreeNode curr = root;
		while(!stack.isEmpty() || curr != null)
		{
			while(curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			TreeNode node = stack.pop();
			System.out.println(node.val);
			if(node.right != null)
			{
				curr = node.right;
			}
		}
	}
}
class TreeUtils
{
     public TreeUtils()
     {
    	 
     }
     int sum = 0;
     TreeNode KthNode(TreeNode pRoot, int k)
     {
         if(pRoot != null){
             TreeNode node = KthNode(pRoot.left,k);
             if(node != null){
            	 System.out.println(node.val+" left");
                 return node;
             }
             System.out.println(sum+"sum");
             if(++sum == k){
                 return pRoot;
             }
             node = KthNode(pRoot.right,k);
             if(node != null){
            	 System.out.println(node.val+"right");
                 return node;
             }
         }
         return null;
     }
}
