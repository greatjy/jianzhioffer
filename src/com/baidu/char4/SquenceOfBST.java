package com.baidu.char4;

public class SquenceOfBST {
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		int[] num = {7,4,6,5};//{5,7,6,9,11,10,8};
		System.out.println(verifySequenceOfBST(num, 0, num.length));
		
	}
    public static boolean verifySequenceOfBST(int[] seq,int start,int end)
    {
    	if(seq == null || end<= 0)
    	{
    		//j表示数组的长度
    		return false;
    	}
    	int root = seq[end-1];
        int i=0;
        for(;i<end-1;i++)
        {
            if(seq[i] > root)
            {
                break;
            }
        }
        int j=i;
        for(;j<end-1;j++)
        {
            if(seq[j] < root)
            {
                return false;
            }
        }
        boolean left = true;
        boolean right = true;
        if(i>start) //切入点不是0 有左半边树
        {
            left = verifySequenceOfBST(seq,start,i);
        }
        if(i<end-1)
        {
            //切入点不是前一个，有右半节点
            right = verifySequenceOfBST(seq,i,end-1);
        }
        return left && right;
    }
}
