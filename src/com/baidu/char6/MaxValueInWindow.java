package com.baidu.char6;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class MaxValueInWindow
{
    public static void main(String[] args)
	{
		int[] data = {2,3,4,2,6,2,5,1};
		int k = 3;
		ArrayList<Integer> maxValue = findMaxInWindow(data,k);
		for(int i:maxValue)
		{
			System.out.print(i+"\t");
		}
	}

	private static ArrayList<Integer> findMaxInWindow(int[] data, int k)
	{
		// 不断入队列的时候进行两件事情 保证双端队列的对头永远是最大值 
		//1.检查最大值是否过期
		//2.删除所有比新加入元素小的值（从队尾比较） 
		//因为新加入的元素如果比前面的最大值大的话，前面的元素不可能是最大值
		ArrayList<Integer> res = new ArrayList<>();
		if(k == 0)
		{
			return res;
		}
		int begin;
		ArrayDeque<Integer> deQueue = new ArrayDeque<>();
		for(int i=0;i<data.length;i++)
		{
			begin = i-k+1;//当前的位置距离第一个可以出结果的下标
			if(deQueue.isEmpty())
			{
				deQueue.add(i);//第一次压入1
			}
			else if(begin > deQueue.peekFirst())
			{
				//当前的对头元素已经过期
				deQueue.pollFirst();
			}
			
			while(!deQueue.isEmpty() && data[deQueue.getLast()] <= data[i])
			{
				deQueue.pollLast();
			}
			deQueue.add(i);
			if (begin>=0)
			{
				res.add(data[deQueue.peekFirst()]);
			}
			for(int j:deQueue)
			{
				System.out.print(j+"\t");
			}
			System.out.println();
		}
		return res;
	}
}
