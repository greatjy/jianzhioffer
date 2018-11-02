package com.baidu.char4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode
{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
		// TODO Auto-generated constructor stub
    	this.value = value;
	}
}
public class MirrorOfTree 
{
    public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		printByLevel(root);
		mirrorTree2(root);
		printByLevel(root);
	}
    public static void mirrorTree(TreeNode root)
    {
    	if(root == null)
    		return;
    	if(root.left == null && root.right == null)
    	{
    		//叶子节点 什么都不做
    		return;
    	}
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	
    	if(root.left != null)
    	{
    		mirrorTree(root.left);
    	}
    	if(root.right != null)
    	{
    		mirrorTree(root.right);
    	}
    	
    	//return root;
    }
    
    public static void printByLevel(TreeNode root)
    {
    	if(root == null)
    		return;
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	while(!queue.isEmpty())
    	{
    		int size = queue.size();
    		for(int i=0;i<size;i++)
    		{
    			TreeNode fNode = queue.poll();
    			System.out.print(fNode.value+"\t");
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
    
    public static void mirrorTree2(TreeNode root)
    {
    	if(root == null)
    	{
    		return;
    	}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	TreeNode treeNode = null;
    	while(!stack.isEmpty())
    	{
    		treeNode = stack.pop();
    		if(treeNode.left != null || treeNode.right != null)
    		{
    		    TreeNode temp = treeNode.left;
    		    treeNode.left = treeNode.right;
    		    treeNode.right = temp;
    		}
    		if(treeNode.left != null)
    		{
    			stack.push(treeNode.left);
    		}
    		if(treeNode.right != null)
    		{
    			stack.push(treeNode.right);
    		}
    	}
    }
}
