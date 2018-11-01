package com.baidu.char2;

class TreeLinkNode
{
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val)
	{
		this.val = val;
	}
}
public class NextNodeOfTree
{
    public static void main(String[] args)
	{
    	TreeLinkNode root = new TreeLinkNode(3);
		System.out.println(nextNode(root));
	}
    
    public static TreeLinkNode nextNode(TreeLinkNode pNode)
    {
    	if(pNode == null)
    		return null;
    	
    	// 如果当前节点包含右子树 那么下一个节点就是右子树的最左节点、
    	if(pNode.right != null)
    	{
    		TreeLinkNode pCurr = pNode.right;
    		while(pCurr.left != null)
    		{
    			pCurr = pCurr.left;
    		}
    		return pCurr;
    	}
    	
    	// 如果当前节点是根节点 并且不满足有右子树的条件 返回null 它不会有下一个节点了
    	if(pNode.next == null)
    		return null;
    	
    	// 如果当前节点 是父节点的左节点 返回其父节点
    	if(pNode.next.left == pNode)
    	{
    		return pNode.next;
    	}
    	
    	// 如果当前节点是父亲的右子树 并且无右子树 那么就一直找到他的父亲满足是其父亲的左子树
    	// 然后返回这个父亲的父亲
    	else {
    		TreeLinkNode pCurr = pNode.next;
    		while(pCurr != null)
    		{
    			if(pCurr.next.left == pCurr)
    			{
    				return pCurr.next;
    			}
    			pCurr = pCurr.next;
    		}
    		return null;
    	}
    }
}
