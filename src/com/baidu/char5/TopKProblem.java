package com.baidu.char5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class TopKProblem
{
    public static void main(String[] args)
	{
		//һ������������ һ����partition����������ѡ��ǰk��������� �����Ǹ���partition������Ҫ������˳������
    	//��һ�����ǻ��ڶѻ��ߺ�����ķ������ʺ��ں�������
    	int[] nums = {2,3,5,3,6,36,43,673,132,56,7,435,7,43,5};
    	int k = 4;
    	ArrayList<Integer> res = new ArrayList<>();
    	res = findTopKProblem(nums,k);
    	System.out.println(res);
	}

	private static ArrayList<Integer> findTopK(int[] nums, int k)
	{
		// �����ҽ�ʹ��֮ǰ����������ʹ�õ�partition����
		ArrayList<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return res;
		int start = 0;
		int end = nums.length-1;
		int index = partition(nums,start,end);//������ŦԪ��λ��
		while(index != k-1)
		{
			if(index > k-1)
			{
				//��k�����ֳ��������,��ʱ�����Ѿ�����
				end = index -1;
				index = partition(nums,start,end);
			}
			else
			{
				start = index +1;
				index = partition(nums,start,end);
			}
		}
		for(int i=0;i<k;i++)
		{
			res.add(nums[i]);
		}
		return res;
	}
	
	private static int partition(int[] nums, int start, int end)
	{
		// �����е�partiotion����
		if (start == end)
		{
			return start;
		}
		int i = start;
		int j = end;
		int key = nums[start];
		while (i != j)
		{
			while (i != j && key <= nums[j])
			{
				j--;
			}
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			while (i != j && key >= nums[i])
			{
				i++;
			}
			int temp2 = nums[i];
			nums[i] = nums[j];
			nums[j] = temp2;
		}
		return i;
	}
	
	public static ArrayList<Integer> findTopKProblem(int [] nums,int k)
	{
		ArrayList<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return res;
		if(k<0 || k>nums.length)
			return res;
		// ������С�� �� �������ʵ�ֵģ���c++ ��ʹ��stl�е�set/multiset
		//��java �п���ʹ��TreeSet ����������Ը�TreeSet�д���Comparator �ӿڶ���
		TreeSet<Integer> set = new TreeSet<>(); //���ں����ʵ�ֵ�
		for(int i=0;i<nums.length;i++)
		{
			System.out.println(set);
			if(set.size() < k)
			{
				set.add(nums[i]);
			}
			else if(nums[i] < set.last())
			{
				set.remove(set.last());
				set.add(nums[i]);
			}
		}
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext())
		{
			res.add(iterator.next());
		}
		return res;
		
	}
}
