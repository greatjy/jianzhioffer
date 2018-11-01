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
		// ��ǰ���������ڱ�i,j��ǰ�������ָʾż��(��ɨ������������������ߣ���
		//���������ָʾ����������ż������ǰ���ߣ�����iɨ�赽ż����jɨ�赽����ʱ��
		//���Ǿͽ��佻��������ɨ����ȥֱ��i,j���������Ǹ÷�����ı�ԭʼԪ�ص����λ�á�
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
		// ����1����򵥵��뷨��������ʱ�临�Ӷȣ�ɨ�����飬����ż������ȡ���������
		//Ȼ�������������ֶ���ǰ���ƶ�һλ��
		//�������ճ�һλ�Ÿ�ż�����ɡ�����Ȼ�������ظ��ƶ��ܶ�Ρ�ʱ�临�ӵ�O(n^2)
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
