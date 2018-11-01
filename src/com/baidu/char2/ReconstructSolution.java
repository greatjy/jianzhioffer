package com.baidu.char2;
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val)
	{
		this.val = val;
	}    
}
public class ReconstructSolution
{
    public static TreeNode reconstruct(int[] pre,int []in)
    {
    	TreeNode root = reconstructTree(pre,in,0,pre.length-1,0,in.length-1);
    	return root;
    }
    
    public static TreeNode reconstructTree(int[] pre,int [] in,int preSt,int preEn,int inSt,int inEn)
    {
    	if(preSt>preEn || inSt>inEn)
    	{
    		return null;
    	}
    	
    	 TreeNode root = new TreeNode(pre[preSt]);
    	 for(int i = inSt;i<=inEn;i++)
    	 {
    		 if(in[i] == pre[preSt])
    		 {
    			 root.left = reconstructTree(pre, in, preSt+1, preSt+i-inSt, inSt,i-1);
    			 //i-inSt 是左子树的长度 同理 inEn - i 是右子树的长度
    			 root.right = reconstructTree(pre, in, preSt+i-inSt+1, preEn, i+1, inEn);
    		 }
    	 }
		return root;
    }
    
  
    
}
