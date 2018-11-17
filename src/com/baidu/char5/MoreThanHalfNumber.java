package com.baidu.char5;

public class MoreThanHalfNumber
{
    public static void main(String[] args)
	{
		int[] nums = {1,2,3,2,2,2,5,4,2};
		int result = findMax(nums);
		System.out.println(result);
	}
    public static int findMax(int[] nums)
    {
    	if(nums == null || nums.length == 0)
    		return 0;
    	int result = nums[0];
    	int times = 1;
    	for(int i=1;i<nums.length;i++)
    	{
    		if(times == 0)
    		{
    			result =  nums[i];
    		}
    		if(nums[i] == result)
    		{
    			times++;
    		}
    		else
    		{
    			times--;
    		}
    	}
    	if(!checkValid(nums,result))
    	{
    		return 0;
    	}
    	return result;
    }
	private static boolean checkValid(int[] nums, int result)
	{
		//出现频率最高的数字没有达到数组的一般；
		int times = 0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i] == result)
			{
				times ++;
			}
		}
		if(times *2 > nums.length)
		{
			return true;
		}
		else
			return false;
	}
}
