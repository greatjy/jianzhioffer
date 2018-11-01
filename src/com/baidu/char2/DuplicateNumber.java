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
    		
    		//���������벿�ֵ�����ͳ��֮�� 
    		int count = countRange(n, length, start, middle);
    		
    		if(end == start)//ѭ����ֹ����
    		{
    			if(count > 1)
    			{
    				dup[0] = start;
    				System.out.println(start);
    				return true;
    			}
    			else
    			{
    				break;//ֻ����һ��Ԫ���� ѭ������ ˵����û�� �ظ��� Ԫ��
    			}
    		}
    		
    		if(count>(middle-start+1))//��벿�� �����ظ�
    		{
    			end = middle;
    		}
    		else//�ж��Ұ벿���Ƿ����ظ�
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
