package com.baidu.char4;


public class ConvertBinarySearchTree 
{
	//�����������Binary Search Tree�������֣���������������������������������һ�ÿ�����
	//�����Ǿ����������ʵĶ������� ���������������գ��������������н���ֵ��С�����ĸ�����ֵ��
	//���������������գ��������������н���ֵ���������ĸ�����ֵ�� ������������Ҳ�ֱ�Ϊ������������
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
		//����һ��˫����������
		//TreeNode ans = convert(root);
		TreeNode ans = Convert(root);
		System.out.println(ans.value);
		//System.out.println(ans.right.right.value);

		
	}

	public static TreeNode convert(TreeNode root)
	{
		/*
		 * ���ӣ�https://www.nowcoder.com/questionTerminal/
		 * 947f6eb80d944a84850b0538bf0ec3a5 ��Դ��ţ����
		 * 
		 * ���������ݹ�� ����˼·�� 1.�������������˫��������������ͷ�ڵ㡣 2.��λ��������˫�������һ���ڵ㡣
		 * 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ����������� 4.�������������˫��������������ͷ�ڵ㡣
		 * 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮�� 6.���������������Ƿ�Ϊ��ȷ�����صĽڵ㡣 public TreeNode
		 * Convert(TreeNode root) {
		 */
		if (root == null)
			return null;
		System.out.println("����convet����"+root.value);
		
		if (root.left == null && root.right == null)
			return root;
		// 1.�������������˫��������������ͷ�ڵ� ��������root�ڵ�
		TreeNode left = convert(root.left);//Ӧ��ʱ���һ����ڵ� Ҳ����4��
		System.out.println("��һ����left"+left.value);
		TreeNode p = left;
		// 2.��λ��������˫�������һ���ڵ�   
		while (p != null && p.right != null)
		{
			p = p.right;//��ǰ�ڵ����ҽڵ㣬ָ�������ҽڵ㣨������������ֵ��
			System.out.println(p.value+"�ڶ��� ���������һ���ڵ�");
		}
		// 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
		//System.out.println(left.value+"l");
		if (left != null)
		{
			p.right = root;
			root.left = p;
			System.out.println(p.value+"<-->"+root.value);
		}
		// 4.�������������˫��������������ͷ�ڵ�//�ڶ��� 4��right = null 
		TreeNode right = convert(root.right);
		// 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
		if (right != null)
		{
			right.left = root;
			root.right = right;
			System.out.println(right.value + "<-->"+root.value);
		}
        
	    System.out.println(left.value+"��һ�η��ص���");
		return left != null ? left : root; //���ض������˴ε�ͷ�ڵ�
	}


	
	public static TreeNode Convert(TreeNode root)
	{
		if (root == null)
			return null;
		get(root); //������Ҫ���ص�ͷ�ڵ�
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
	        }//�õ����������������ڵ�
	        if(root.right!=null){
	            TreeNode next = get(root.right);
	            while(next.left!=null)
	                next = next.left;
	            next.left = root;
	            root.right = next;
	            System.out.println(root.value+"-->"+next.value);
	        }//�õ���������������С�ڵ�
	        System.out.println("��һ�η��ص���"+root.value);
	        return root;
	    }
	    
}
