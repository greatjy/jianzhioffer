package com.baidu.char6;

import java.util.ArrayList;
import java.util.LinkedList;

public class LCAProblem
{
    public static void main(String[] args)
	{
    	TreeNode1 A = new TreeNode1();
        A.value = 'A';
        TreeNode1 B = new TreeNode1();
        B.value = 'B';
        TreeNode1 C = new TreeNode1();
        C.value = 'C';
        TreeNode1 D = new TreeNode1();
        D.value = 'D';
        TreeNode1 E = new TreeNode1();
        E.value = 'E';
        TreeNode1 F = new TreeNode1();
        F.value = 'F';
        TreeNode1 G = new TreeNode1();
        G.value = 'G';
        TreeNode1 H = new TreeNode1();
        H.value = 'H';
        TreeNode1 I = new TreeNode1();
        I.value = 'I';
        TreeNode1 J = new TreeNode1();
        J.value = 'J';
        A.childs = new TreeNode1[] {B,C};
        B.childs = new TreeNode1[] {D,E};
        D.childs = new TreeNode1[] {F,G};
        E.childs = new TreeNode1[] {H,I,J};
        findLca(F, H, A);
	}
    
    public static TreeNode findLCA(TreeNode node1,TreeNode node2,TreeNode root)
    {
    	int value = (root.val);
    	if(value > node1.val && value > node2.val)
    		return findLCA(node1, node2, root.left);
    	else if(value < node1.val && value < node2 .val)
    		return findLCA(node1, node2, root.right);
    	return root;
    }
    
    public static TreeNodeHasParent findLCA2(TreeNodeHasParent node1, TreeNodeHasParent node2,TreeNodeHasParent root)
    {
    	LinkedList<TreeNodeHasParent> list = new LinkedList<>();
    	while(node1 != root)
    	{
    		list.add(node1);
    		node1 = node1.parent;
    	}
    	list.add(root);
    	LinkedList<TreeNodeHasParent> list2 = new LinkedList<>();
    	while(node2 != root)
    	{
    		list2.add(node1);
    		node2 = node2.parent;
    	}
    	list2.add(root);
    	//随后按照两个链表中的首次出现重合的位置 来做这道题
    	return root; 
    }
    
    public static TreeNode1 findLca(TreeNode1 node1,TreeNode1 node2,TreeNode1 root)
    {
    	//首先需要一个函数建立从root 到 node 的节点
    	LinkedList<TreeNode1> list1 = new LinkedList<>(); 
    	LinkedList<TreeNode1> list2 = new LinkedList<>();
    	ArrayList<LinkedList<TreeNode1>> res = new ArrayList<>();
        ArrayList<LinkedList<TreeNode1>> res2 = new ArrayList<>();
    	getPathFromNodeToRoot(node1,root,list1,res);
    	getPathFromNodeToRoot(node2,root,list2,res2);
    	for(LinkedList<TreeNode1> node11 : res)
    	{
    		for(TreeNode1 node13 : node11)
    		{
    			System.out.println(node13);
    		}
    	}
    	return new TreeNode1();
    	
    }

    public  static ArrayList<LinkedList<TreeNode1>> res = new ArrayList<>();
	private static void getPathFromNodeToRoot(TreeNode1 node1, TreeNode1 root,LinkedList<TreeNode1> list,ArrayList<LinkedList<TreeNode1>> res)
	{
		if(root.value != node1.value && root.childs == null)
		{
			list.add(root);
			return;
		}
		if(node1.value == root.value)
		{
			list.add(root);
			LinkedList<TreeNode1> temp = new LinkedList<>(list);
			res.add(temp);
			return;
		}

		list.add(root);
		for(TreeNode1 node12 : list)
		{
			System.out.println(node12.toString());
		}
		System.out.println("hellowarld");
		TreeNode1[] child = root.childs;
		for(int i=0;i<child.length;i++)
		{
			getPathFromNodeToRoot(node1,child[i], list,res);
			list.removeLast();
		}
	}
}
class TreeNodeHasParent
{
	 int val;
     public TreeNodeHasParent(int val)
     {
    	 this.val = val;
     }
     TreeNodeHasParent left;
     TreeNodeHasParent right;
     TreeNodeHasParent parent;
}
class TreeNode1 {
	     char value;
	      TreeNode1 childs[];
	      @Override
	     public String toString() {
	         return "TreeNode1 [value=" + value + "]";
     }
 }
