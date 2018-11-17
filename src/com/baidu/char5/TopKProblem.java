package com.baidu.char5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class TopKProblem
{
    public static void main(String[] args)
	{
		//一共有两个方法 一个是partition方法可以挑选出前k个大的数字 ，但是根据partition函数的要求，数组顺序会打乱
    	//另一个就是基于堆或者红黑树的方法，适合于海量数据
    	int[] nums = {2,3,5,3,6,36,43,673,132,56,7,435,7,43,5};
    	int k = 4;
    	ArrayList<Integer> res = new ArrayList<>();
    	res = findTopKProblem(nums,k);
    	System.out.println(res);
	}

	private static ArrayList<Integer> findTopK(int[] nums, int k)
	{
		// 这里我将使用之前快速排序中使用的partition函数
		ArrayList<Integer> res = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return res;
		int start = 0;
		int end = nums.length-1;
		int index = partition(nums,start,end);//返回枢纽元的位置
		while(index != k-1)
		{
			if(index > k-1)
			{
				//第k个数字出现在左边,此时数组已经变了
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
		// 快排中的partiotion函数
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
		// 基于最小堆 和 红黑树来实现的，在c++ 中使用stl中的set/multiset
		//在java 中可以使用TreeSet 其他规则可以给TreeSet中传入Comparator 接口对象
		TreeSet<Integer> set = new TreeSet<>(); //基于红黑树实现的
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
