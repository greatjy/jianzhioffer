package com.baidu.char4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintByLevel 
{
	//public static ArrayList<Integer> res = new ArrayList<>();
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.right.right = new TreeNode(3);
		root.right.right.left = new TreeNode(7);
		ArrayList<Integer> aList = PrintFromTopToBottom(root);
		System.out.println(aList);
		
	}
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) 
    {
    	ArrayList<Integer> res = new ArrayList<Integer>(); 
        return printlevel(root, res);
    }
    public static ArrayList<Integer> printlevel(TreeNode root,ArrayList<Integer> res)
    {
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
        {
        	return res;
        }
        queue.add(root);
        while(!queue.isEmpty())
        {
        	int size = queue.size();
        	for(int i=0;i<size;i++)
        	{
        		TreeNode cur = queue.poll();
        		res.add(cur.value);
        		//System.out.println(cur.value);
        		if(cur.left != null)
        		{
        			queue.add(cur.left);
        		}
        		if(cur.right != null)
        		{
        			queue.add(cur.right);
        		}
        	}
        	//System.out.println();
        }
		return res;
    }
}
