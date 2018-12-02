package com.baidu.char6;

public class NumberOfK
{
    public static void main(String[] args)
	{
		//聪明人大多失眠，美人大多闲
    	int[] nums = {3,3,3,3,4,5};
    	int k = 3;
    	System.out.println(findNumberOfK(nums,k));
    	int [] numss= {0,1,2,3,4,6,7,8,9};
    	System.out.println(middingNumber(numss));
	}

    private static int middingNumber(int[] nums)
	{
		if(nums == null || nums.length == 0)
			return 0;
		int left = 0;
		int right = nums.length-1;
		while(left <= right)
		{
			int mid = left + (right-left)/2;
			if(mid == left || (nums[mid]!=mid && nums[mid-1] == mid-1))
			{
				return mid;
			}
			else if(nums[mid] == mid)
			{
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		return left;
	}

	//在排序序列中找打最先开始的下标和最后开始的下标相减得到了这个数字在排序数组中出现的次数
	private static int findNumberOfK(int[] nums, int k)
	{
		if(nums == null || nums.length == 0)
			return 0;
		//二分查找 寻找最先开始的小标和最后开始的下标
		int index1 = getFirstK(nums,k,0,nums.length-1);
		int index2 = getLast(nums,k,0,nums.length-1);
		//System.out.println(index1 + " "+ index2);
		if(index1 > -1 && index2 > -1)
			return index2-index1+1;
        return 0;
	}

	private static int getFirstK(int[] nums, int k,int left,int right)
	{
		// binarysearch to find the first k
		if(left > right)
			return -1;
		int mid = left+(right-left)/2;
		int middleData = nums[mid];
		if(middleData == k)
		{
			if((mid>0 && nums[mid-1] != middleData)||mid == 0) 
			{
				return mid;
			}
			else 
			{
				right = mid-1;
				return getFirstK(nums, k, left, right);
			}
		}
		else if(middleData > k)
		{
			return getFirstK(nums, k, left, mid-1);
		}
		else
		{
			return getFirstK(nums, k, mid+1, right);
		}
	}

	private static int getLast(int[] nums, int k,int left, int right)
	{

		while(left <= right)
		{
			int mid = left+(right-left)/2;
			//System.out.println("mid"+mid);
			if(nums[mid] == k)
			{
				//System.out.println("left"+left);
				if(mid == right ||(nums[mid+1]!=k))
				{
					return mid;
				}
				else
				{
					left = mid+1;
				}
			}
			else if(nums[mid] > k)
			{
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		return -1;		
	}
}
