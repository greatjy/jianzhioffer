package com.baidu.char2;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTop
{
    public static void main(String[] args)
	{
		//����bfs�ķ�ʽ�����������
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
    	//�ȴ�ӡ���ڵ㣬Ϊ�˴�ӡ���ڵ�������ӽڵ㣬�����������ӽڵ㣬
    	//�ڲ��ϵ������ĸ��ڵ��ͬʱ��������ӽڵ�������
    	//���������ǲ��ᵯ��ֻ���¼
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
