package com.baidu.char5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//�������ų���С����
public class SortInSmall
{
    public static void main(String[] args)
	{
		int[] nums = {3,32,321};
		System.out.println(printMinNumber(nums));
	}
    public static String printMinNumber(int[] nums)
    {
    	//�����е����� ��������
    	//����ı�׼ ��������������ӵ��ַ��� ˭�Ƚ�С
    	if(nums == null || nums.length == 0)
    		return "";
    	ArrayList<Integer> list = new ArrayList<>();
    	String ans = "";
    	for(int i=0;i<nums.length;i++)
    	{
    		list.add(nums[i]);
    	}
    	Collections.sort(list,new Comparator<Integer>()
		{

			@Override
			public int compare(Integer o1, Integer o2)
			{
				String s1 = o1+""+o2;
				String s2 = o2+""+o1;
				return s1.compareTo(s2);
			}    		
		});
    	for(int j:list)
    	{
    		ans += j;
    	}
    	return ans;
    }
}
