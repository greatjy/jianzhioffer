package com.baidu.char5;

public class InversePairs
{
    public static void main(String[] args)
	{
		int[] nums= {2,6,3,5,1,4,7,9,8};
		mergeSort(nums);
		int[] array = {7,5,6,4};
		System.out.println(inversePairsProblem(array));
	}

	private static void mergeSort(int[] nums)
	{
		if(nums == null || nums.length == 0)
			return;
		int l = 0;
		int r = nums.length-1;
		int[] temp = new int[nums.length];
		if(l >= r)
			return;
		mergeSortalgo(nums,l,r,temp);
	}

	private static void mergeSortalgo(int[] nums, int l, int r, int[] temp)
	{
		if(l >= r)
			return;
		int mid = l+(r-l)/2;
		//System.out.println(l+" "+r);
		mergeSortalgo(nums, l, mid, temp);
		mergeSortalgo(nums, mid+1, r, temp);
		merge(nums,l,r);
	}
	private static void merge(int[] nums,int l,int r)
	{

		if(nums == null || nums.length == 0)
			return;
		
		int[] temp = new int[nums.length];
		int mid = l+(r-l)/2;
		int p1 = l;
		int p2 = mid+1;
		int temppos = l;        
	    while(p1 <= mid && p2 <= r)
	    {
	    	if(nums[p1] < nums[p2])
	    	{
	    		temp[temppos++] = nums[p1];
	    		p1++;
	    	}
	    	else
	    	{
	    		temp[temppos++] = nums[p2];
	    		p2++;
	    	}
	    }
    	while(p1 <= mid)
    	{
    		//System.out.println(temppos);
    		temp[temppos++] = nums[p1++];
    	}
	    while(p2 <= r)
	    {
	    	temp[temppos++] = nums[p2++];
	    }	    
	    for(int i=l;i<=r;i++)
	    {
	    	nums[i] = temp[i];
	    }
	}
	
	static int count = 0;
	public static int inversePairsProblem(int[] nums)
	{
		//改写mergeSort]
		count = 0;
		if(nums == null || nums.length == 0)
			return 0;
		mergeSortToDown(nums,0,nums.length-1);
		return count;
		
	}

	private static void mergeSortToDown(int[] nums, int left, int right)
	{
		//归并排序的步骤
		if(left >= right)
			return;
		int mid = left+(right-left)/2;
		mergeSortToDown(nums, left, mid);
		mergeSortToDown(nums, mid+1, right);
		merge(nums, left,mid, right);
		
	}

	private static void merge(int[] nums, int left, int mid, int right)
	{
		int[] temp = new int[right-left+1];
		int p1 = left;
		int p2 = mid+1;
		int temppos = 0;
		while(p1<= mid && p2<=right)
		{
			if(nums[p1]>nums[p2])
			{
				count += mid-p1+1;//从p1 到mid 全部都是逆序数
				//System.out.println(count+" "+p1+" "+p2);
				temp[temppos++] = nums[p2++];
			}
			else
			{
				temp[temppos++] = nums[p1++];
			}
		}
		while(p1 <= mid)
		{
			temp[temppos++] = nums[p1++];
		}
		while(p2 <= right)
		{
			temp[temppos++] = nums[p2++];
		}
		for(int i=0;i<temp.length;i++)
		{
			nums[i+left] = temp[i];
		}	
	}	
}
