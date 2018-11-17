package com.baidu.char5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StreamMedianProblem
{
    public static void main(String[] args)
	{
		for(int i=0;i<10;i++)
		{
			insert(i);
			System.out.println(getMedian());
		}
	}
    public static PriorityQueue<Integer> left = new PriorityQueue<Integer>(new Comparator<Integer>()
	{
    	public int compare(Integer o1, Integer o2)
    	{
    		return o2 - o1;
    	}
	}); // 大顶堆
    public static PriorityQueue<Integer> right = new PriorityQueue<>();//小顶堆
    public static int count = 0;
    private static void insert(Integer num)
    {
    	if((count&1) == 0)
    	{
    		if(!right.isEmpty() && num>right.peek())
    		{
    			//右边不为空 并且右边的最小值小于输入的这个值
    			//右边抛弃最小值到左边，并添加这个值
    			right.offer(num);
    			num = right.poll();
    		}

    			left.offer(num);//先给左边来
    	}
    	else
    	{
    		if(!left.isEmpty() && num< left.peek())
    		{
    			left.offer(num);
    			num = left.poll();
    		}
    		right.offer(num);
    		
    	}
    	count++;
    }
    private static Double getMedian()
    {
    	if((count&1) == 0 )
    		return (double)(left.peek()+right.peek())/2;
    	else
    		return (double)left.peek();
    }
}
