package com.baidu.char2;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTop
{
    public static void main(String[] args)
	{
		//采用bfs的方式来层序遍历树
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);
    	printTreeInALine(root);
    	printTree(root);
    	printTree2(root);
    	
	}
    
    public static void printTreeInALine(TreeNode root)
    {
    	if(root == null)
    		return;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while(!queue.isEmpty()) 
    	{
    		TreeNode node = queue.poll();
    		System.out.print(node.val+" ");
    		if(node.left != null)
    		{
    			queue.add(node.left);
    		}
    		if(node.right != null)
    		{
    			queue.offer(node.right);
    		}
    	}
    	System.out.println();
    }
    public static void printTree(TreeNode root)
    {
    	//先打印根节点，为了打印根节点的两个子节点，保存这两个子节点，
    	//在不断弹出他的父节点的同时添加他的子节点进入队列
    	//这种做法是不会弹出只会记录
    	if(root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
        	for(int i=queue.size();i>0;i--)
        	{
        		TreeNode node = queue.poll();
        		System.out.print(node.val);
        		if(node.left != null)
        		{
        			queue.offer(node.left);
        		}
        		if(node.right != null)
        		{
        			queue.offer(node.right);
        		}
        	}
        
            System.out.println();
        }
    }
    
    public static void printTree2(TreeNode root)
    {
    	if(root == null)
    		return;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	int toBePrint = 1;
    	int nextLevel = 0;
    	while(!queue.isEmpty())
    	{
    		TreeNode node = queue.poll();
    		--toBePrint;
    		System.out.print(node.val);
    		
    		if(node.left != null)
    		{
    			queue.add(node.left);
    			++nextLevel;
    		}
    		
    		if(node.right != null)
    		{
    			queue.add(node.right);
    			++nextLevel;
    		}
    		
    		if(toBePrint == 0)
    		{
    			System.out.println();
    			toBePrint = nextLevel;
    			nextLevel = 0;
    		}
    	}
    }
}
