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
	}); // �󶥶�
    public static PriorityQueue<Integer> right = new PriorityQueue<>();//С����
    public static int count = 0;
    private static void insert(Integer num)
    {
    	if((count&1) == 0)
    	{
    		if(!right.isEmpty() && num>right.peek())
    		{
    			//�ұ߲�Ϊ�� �����ұߵ���СֵС����������ֵ
    			//�ұ�������Сֵ����ߣ���������ֵ
    			right.offer(num);
    			num = right.poll();
    		}

    			left.offer(num);//�ȸ������
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
