package com.baidu.char4;

import java.util.ArrayList;



public class PathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(5);
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		System.out.println(findPath(root, 17));
		System.out.println("the answer is"+findPathSum(root,21,list,res));
	}
	public static boolean findPath(TreeNode root,int target)
	{
		//回溯解决
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root == null)
		{			
			//list.add(root.value);
			return false;
		}
		if(root.value == target && root.left == null && root.right == null)
		{
			//list.add(root.value);
			return true;
		}
		return findPath(root.left, target-root.value) || findPath(root.right, target-root.value);
		
	}
	
	public static ArrayList<ArrayList<Integer>> findPathSum(TreeNode root,int target,ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> res)
	{
		// use backtrace to solve this problem
		list.add(root.value);//初始条件
		//边界条件

		if(root.value == target && root.left == null && root.right == null)
		{
			ArrayList<Integer> ans = new ArrayList<Integer>(list);
			res.add(ans);//深拷贝保存结果
		}
		//遍历过程
		if(root.left != null)
		{
		    findPathSum(root.left, target-root.value,list,res);
			list.remove(list.size()-1);//回溯过程
		}
		
		if(root.right != null)
		{
			findPathSum(root.right, target-root.value,list,res);
			list.remove(list.size()-1);//回溯过程
		}
		//list = (ArrayList<Integer>) list.subList(0, list.size()-1);
				//回溯过程

		return res;
	}

}
