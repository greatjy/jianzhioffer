package com.baidu.char2;

public class FindNumberInRotate
{
	public static void main(String[] args)
	{
		int[] arr = { 3, 4, 5, 1, 2 ,3};
		// Sstem.out.println(findMin(arr));
		System.out.println(minNumberInRotateArray(arr));
		System.out.println(minNumberInRotateArray1(arr));
	}

	public static int minNumberInRotateArray(int[] array)
	{
		if (array == null || array.length == 0)
		{
			return 0;
		}
		int p1 = 0;// 从前往后走
		int p2 = array.length - 1;// 从后往前走
		int min = array[p1];// 如果没发生旋转，直接将array[0]的值返回，
		int mid = 0;
		// 当数组发生旋转了，
		while (array[p1] >= array[p2])
		{
			// 当两个指针走到挨着的位置时，p2就是最小数了
			if (p2 - p1 == 1)
			{
				min = array[p2];
				break;
			}
			mid = (p1 + p2) / 2;
			// 如果中间位置的数既等于p1位置的数又等于P2位置的数
			if (array[p1] == array[mid] && array[p2] == array[mid])
			{
				min = minInorder(array, p1, p2);
			}
			if (array[p1] <= array[mid])// 若中间位置的数位于数组1，让p1走到mid的位置
			{
				p1 = mid;
			} else if (array[p2] >= array[mid])// 若中间位置的数位于数组2，让p2走到mid的位置
			{
				p2 = mid;
			}
		}
		return min;
	}

	private static int minInorder(int[] array, int p1, int p2)
	{
		int min = array[p1];
		for (int i = p1 + 1; i <= p2; i++)
		{
			if (min > array[i])
			{
				min = array[i];
			}
		}
		return min;
	}
	 public static int minNumberInRotateArray1(int [] array) 
	    {
	        if(array == null || array.length == 0)
	            return 0;
	        int left = 0;
	        int right = array.length-1;
	        int mid = 0;//如果是没有旋转的数组 那么直接返回 array[0]
	        while(array[left]>=array[right])
	        {
	            //数组进行了旋转
	            if(right - left == 1)
	            {
	                //最后出现两个数字挨着的情况 
	                mid = right;
	                break;
	            }
	            mid = left+(right-left)/2;
	            if(array[right] == array[mid] && array[left] == array[mid])
	            {
	                return minInOrder(array);
	            }
	            else if(array[left]<=array[mid])
	            {
	                left = mid;
	            }
	            else if(array[right]>=array[mid])
	            {
	                right = mid;
	            }            
	        }
	        return array[mid];
	    }
	    public static int minInOrder(int[] array)
	    {
	        int min = array[0];
	        for(int i=0;i<array.length;i++)
	        {
	            if(array[i]<min)
	            {
	                min = array[i];
	            }
	        }
	        return min;
	    }
}
