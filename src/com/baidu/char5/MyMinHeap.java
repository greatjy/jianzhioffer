package com.baidu.char5;

//自己创建一个最小堆的结构
public class MyMinHeap
{
    //底层机构是用数组来实现的，堆事实上就是一个完全二叉树
	private int[] data;

	public MyMinHeap(int[] data)
	{
		super();
		this.data = data;
		buildHeap(data);
	}

	private void buildHeap(int[] data)
	{
		// 根据传入的数组来实现最小堆的
		// 和堆排序一样，从最后一个有孩子的节点开始，比较和孩子之间的大小，
		// 如果孩子小于父亲，则交换孩子和父亲节点
		for(int i=(data.length)/2-1;i>=0;i--)
		{
			//最后一个有孩子节点的完全二叉树 的下表就是 len/2-1 
			// 奇数时 7 个 last = 2 偶数时 8个 last = 3
			healpify(i);//从这个节点开始向根节点进行调整
		}
		
	}
	private void healpify(int i)
	{
		int left = getLeft(i);
		int right = getRight(i);
		
		int smallerOfChildren = i;//当前节点，孩子节点中最小的那个节点
		if(left < data.length && data[left]<data[i])
			smallerOfChildren = left;
		if(right<data.length && data[right]<data[smallerOfChildren])
			smallerOfChildren = right;
		
		if(i == smallerOfChildren)
		{
			return;
		}
		
		swap(i,smallerOfChildren);
		//由于交换后左右子树会被影响，所以要对受影响的子树再次进行helpify 
		
		//保证每一个节点的父亲都比孩子要小
		healpify(smallerOfChildren);//对其子树再次形成  这样会保证最小的节点一定会在最上面
	}
	
	public int getLeft(int i)
	{
		return (i+1)*2-1; //2的左孩子是 5，有孩子是6
	}
	
	public  int getRight(int i)
	{
		return (i+1)*2;
	}
	
	public int getRoot()
	{
		return data[0];
	}
	private void swap(int i,int j)
	{
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	public void setRoot(int root)
	{
		data[0] = root; //头节点是最
		healpify(0);
	}
	
}
