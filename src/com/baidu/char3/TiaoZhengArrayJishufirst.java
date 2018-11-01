package com.baidu.char3;

public class TiaoZhengArrayJishufirst
{
     public static void main(String[] args)
	{
		int[] nums = {1,2,3,45,6,7,8,9,0};
		//reSort1(nums);
		reSort2(nums);
		for(int i:nums) {
			System.out.println(i);
		}
	}

	private static void reSort2(int[] nums)
	{
		// 在前后安排两个哨兵i,j，前面的用来指示偶数(即扫描如果是奇数就往后走），
		//后面的用来指示奇数（遇到偶数就往前面走），当i扫描到偶数而j扫描到奇数时，
		//我们就将其交换。类似扫描下去直到i,j相遇。但是该方法会改变原始元素的相对位置。
		if(nums == null || nums.length <=1)
			return;
		int i=0;
		int j = nums.length-1;
		while(i<j)
		{

			while(i<j&& func(nums[j]))
			{
				j--;
			}
			while(i<j && !func(nums[i]))
			{
				i++;
			}
			if(i < j)
			{
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		
	}

	private static boolean func(int i)
	{
		
		return (i%2 == 0);
	}

	private static void reSort1(int[] nums)
	{
		// 方法1：最简单的想法，不考虑时间复杂度，扫描数组，遇到偶数，先取出这个数，
		//然后把它后面的数字都往前面移动一位，
		//这样最后空出一位放该偶数即可。但显然这样会重复移动很多次。时间复杂的O(n^2)
		int count = 0;
		for(int i=0;i<nums.length&&count <nums.length;i++)
		{
			if(nums[i]%2 == 0)
			{
				int temp = nums[i];
				for(int j=i;j<nums.length-1;j++)
				{
					nums[j] = nums[j+1];
				}
				nums[nums.length-1] = temp;
				i--;
			}
		}
	}
}
