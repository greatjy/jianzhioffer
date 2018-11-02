package com.baidu.char4;

public class IsSym 
{
    public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(5);
		System.out.println(isSymmertic(root));
	}

	private static boolean isSymmertic(TreeNode root) {
		if(root == null)
			return false;
		return isSymmer(root.left, root.right);
		
	}
	public static boolean isSymmer(TreeNode root1,TreeNode root2)
	{
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.value != root2.value)
		{
			return false;
		}
		return isSymmer(root1.left, root2.right) && isSymmer(root1.right, root2.left);
		
	}
}
