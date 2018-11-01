package com.baidu.char2;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class DuplicateNumber
{
    public static void main(String[] args)
	{
	     int[] n = {2,1,3,1,4};
	     int len = 5;
	     int[]dup = new int[1];
	     System.out.println(isDup(n, len, dup));
	     
	}
    public static boolean isDup(int n[],int length,int[] dup)
    {
    	if(n == null || n.length == 0)
    	{
    		return false;
    	}
    	int start = 0;
    	int end = length-1;
    	while(start<=end)
    	{
    		int middle = ((end-start)>>1)+start;
    		
    		//在数组的左半部分的数字统计之和 
    		int count = countRange(n, length, start, middle);
    		
    		if(end == start)//循环终止条件
    		{
    			if(count > 1)
    			{
    				dup[0] = start;
    				System.out.println(start);
    				return true;
    			}
    			else
    			{
    				break;//只有这一个元素了 循环结束 说明并没有 重复的 元素
    			}
    		}
    		
    		if(count>(middle-start+1))//左半部分 必有重复
    		{
    			end = middle;
    		}
    		else//判断右半部分是否有重复
    		{
    			start = middle+1;
    		}
    	}
    	return false;
    }
    public static int countRange(int[] numbers,int length,int start,int end)
    {  
    	if(numbers == null || numbers.length == 0)
    	{
    		return 0;
    	}
    	int count = 0;
    	for(int i =0;i<length;i++)
    	{
    		if(numbers[i]>=start && numbers[i]<=end)
    		{
    			count++;
    		}
    	}
    	return count;
    }
}
