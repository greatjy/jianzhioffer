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
    	
    	// �����ǰ�ڵ���������� ��ô��һ���ڵ����������������ڵ㡢
    	if(pNode.right != null)
    	{
    		TreeLinkNode pCurr = pNode.right;
    		while(pCurr.left != null)
    		{
    			pCurr = pCurr.left;
    		}
    		return pCurr;
    	}
    	
    	// �����ǰ�ڵ��Ǹ��ڵ� ���Ҳ������������������� ����null ����������һ���ڵ���
    	if(pNode.next == null)
    		return null;
    	
    	// �����ǰ�ڵ� �Ǹ��ڵ����ڵ� �����丸�ڵ�
    	if(pNode.next.left == pNode)
    	{
    		return pNode.next;
    	}
    	
    	// �����ǰ�ڵ��Ǹ��׵������� ������������ ��ô��һֱ�ҵ����ĸ����������丸�׵�������
    	// Ȼ�󷵻�������׵ĸ���
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
