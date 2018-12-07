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
		// ��������е�ʱ������������� ��֤˫�˶��еĶ�ͷ��Զ�����ֵ 
		//1.������ֵ�Ƿ����
		//2.ɾ�����б��¼���Ԫ��С��ֵ���Ӷ�β�Ƚϣ� 
		//��Ϊ�¼����Ԫ�������ǰ������ֵ��Ļ���ǰ���Ԫ�ز����������ֵ
		ArrayList<Integer> res = new ArrayList<>();
		if(k == 0)
		{
			return res;
		}
		int begin;
		ArrayDeque<Integer> deQueue = new ArrayDeque<>();
		for(int i=0;i<data.length;i++)
		{
			begin = i-k+1;//��ǰ��λ�þ����һ�����Գ�������±�
			if(deQueue.isEmpty())
			{
				deQueue.add(i);//��һ��ѹ��1
			}
			else if(begin > deQueue.peekFirst())
			{
				//��ǰ�Ķ�ͷԪ���Ѿ�����
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
