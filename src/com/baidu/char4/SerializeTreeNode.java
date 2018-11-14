package com.baidu.char4;


import java.util.LinkedList;
import java.util.Queue;


public class SerializeTreeNode
{
    public static void main(String[] args)
	{
		/*TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(16);*/
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.right.left = new TreeNode(5);
    	root.right.right = new TreeNode(6);	
		String ans = serialize(root);
		System.out.println(ans.substring(0,ans.length()-1));
		TreeNode root1 = deSerialize(ans);
		System.out.println(root1);
		printByLevel(root1);
		//System.out.println(root.value+" "+root.left.value+" "+root.right.value+" "+root.left.left.value+root.right.left.value);
		
		
	}

	private static String serialize(TreeNode root)
	{
		StringBuffer sBuffer = new StringBuffer();
		pre(root,sBuffer);//前序序列化二叉树
		return sBuffer.toString();
	}
	private static void pre(TreeNode root,StringBuffer sb)
	{
		if(root == null)
		{
			sb.append("$,");
			return;
		}
		else
		{
			sb.append(root.value+",");
			pre(root.left, sb);
			pre(root.right, sb);
		}
	}
	public static int index = 0;
	private static TreeNode deSerialize(String s)
	{
		String[] treeNode = s.split(",");
		TreeNode root = null;
		if(!treeNode[index].equals("$"))
		{
			root = new TreeNode(Integer.parseInt(treeNode[index]));
			index++;
			root.left = deSerialize(s);//index 必须同步更新
			root.right = deSerialize(s);
			return root;
		}
		else
		{
			index++;
			return null;
		}
	}
	
	private static void printByLevel(TreeNode root)
	{
		/*if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			int size = queue.size();

			for(int i=0;i<size;i++)
			{
				TreeNode node = queue.poll();
				System.out.print(node.value+"\t");
				if(node.left != null)
				{
					queue.add(node.left);
				}
				if(node.right != null)
				{
					queue.add(node.right);
				}				
			}
			System.out.println();
		}*/
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                System.out.print(node.value+"\t");
                 
                if(node.left != null)
                {
                    queue.add(node.left);
                }
                 
                if(node.right != null)
                {
                    queue.add(node.right);
                }
                 
            }
            System.out.println();
        }
	}
}
