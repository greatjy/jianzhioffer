package com.baidu.char4;


public class ConvertBinarySearchTree 
{
	//二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，
	//或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
	//若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
     public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(16);
		
		/*root.left .left .left = new TreeNode(3);
		root.left .left.right  = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(15);
		root.right.right.right = new TreeNode(17);
*/		//TreeNode ans = convert(root);
		//printByLevel(ans);
		//构造一个双向有序链表
		//TreeNode ans = convert(root);
		TreeNode ans = Convert(root);
		System.out.println(ans.value);
		//System.out.println(ans.right.right.value);

		
	}

	public static TreeNode convert(TreeNode root)
	{
		/*
		 * 链接：https://www.nowcoder.com/questionTerminal/
		 * 947f6eb80d944a84850b0538bf0ec3a5 来源：牛客网
		 * 
		 * 方法二：递归版 解题思路： 1.将左子树构造成双链表，并返回链表头节点。 2.定位至左子树双链表最后一个节点。
		 * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。 4.将右子树构造成双链表，并返回链表头节点。
		 * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。 6.根据左子树链表是否为空确定返回的节点。 public TreeNode
		 * Convert(TreeNode root) {
		 */
		if (root == null)
			return null;
		System.out.println("调用convet函数"+root.value);
		
		if (root.left == null && root.right == null)
			return root;
		// 1.将左子树构造成双链表，并返回链表头节点 左子树的root节点
		TreeNode left = convert(root.left);//应该时最后一个左节点 也就是4；
		System.out.println("第一步的left"+left.value);
		TreeNode p = left;
		// 2.定位至左子树双链表最后一个节点   
		while (p != null && p.right != null)
		{
			p = p.right;//当前节点有右节点，指向他的右节点（二叉树中最大的值）
			System.out.println(p.value+"第二步 左子树最后一个节点");
		}
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		//System.out.println(left.value+"l");
		if (left != null)
		{
			p.right = root;
			root.left = p;
			System.out.println(p.value+"<-->"+root.value);
		}
		// 4.将右子树构造成双链表，并返回链表头节点//第二部 4的right = null 
		TreeNode right = convert(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if (right != null)
		{
			right.left = root;
			root.right = right;
			System.out.println(right.value + "<-->"+root.value);
		}
        
	    System.out.println(left.value+"这一次返回的是");
		return left != null ? left : root; //返回二叉树此次的头节点
	}


	
	public static TreeNode Convert(TreeNode root)
	{
		if (root == null)
			return null;
		get(root); //我们需要返回的头节点
		while (root.left != null)
			root = root.left;
		return root;
	}
	 
	    public static TreeNode get(TreeNode root) {
	        if(root.left!=null){
	            TreeNode pre = get(root.left);
	            while(pre.right!=null)
	                pre = pre.right;
	            pre.right = root;
	            root.left = pre;
	            System.out.println(root.value+"-->"+pre.value);
	        }//得到的是左子树的最大节点
	        if(root.right!=null){
	            TreeNode next = get(root.right);
	            while(next.left!=null)
	                next = next.left;
	            next.left = root;
	            root.right = next;
	            System.out.println(root.value+"-->"+next.value);
	        }//得到的是右子树的最小节点
	        System.out.println("这一次返回的是"+root.value);
	        return root;
	    }
	    
}
