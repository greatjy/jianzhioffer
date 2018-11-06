package com.baidu.char4;

import java.util.ArrayList;
import java.util.Stack;

public class PrintZigzag {
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		ArrayList<ArrayList<Integer>> res = printbyZigzag(root);
		System.out.println(res);
	}

	private static ArrayList<ArrayList<Integer>> printbyZigzag(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		// TODO Auto-generated method stub
		if(root == null)
			return res;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		int curr = 0;
		int next = 1; // cur 和 next 分别表示了两种不同的栈
		stack1.push(root);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!stack1.isEmpty() || !stack2.isEmpty())
		{

			if(curr == 0)
			{
				//当前是奇数层
				//使用辅助栈1 从左到右添加下一层				
				TreeNode node = stack1.pop();
				System.out.println(node.value);
				list.add(node.value);
				if(node.left != null)
				{
					stack2.push(node.left);
				}
				if(node.right != null)
				{
					stack2.push(node.right);
				}
				if(stack1.isEmpty())
				{
					curr = 1;
					res.add(list);
					list = new ArrayList<Integer>();
				}
			}
			else{
				TreeNode node = stack2.pop();
				System.out.println(node.value);
				list.add(node.value);
				if(node.right != null)
				{
					stack1.push(node.right);
				}
				if(node.left != null)
				{
					stack1.push(node.left);
				}
				if(stack2.isEmpty())
				{
					curr = 0;
					res.add(list);
					list = new ArrayList<Integer>();
				}
			}
			
		}
		return res;
		
	}
}
