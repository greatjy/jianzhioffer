package com.baidu.char5;

public class UglyNumber
{
    public static void main(String[] args)
	{
		int index = 15;
		System.out.println(theUglyNumberOfIndex(index));
	}

	private static int theUglyNumberOfIndex(int index)
	{
		// �ҵ���index����������Ҫ����index ���� �����ĺ���ĳ�������
		if(index < 0 )
			return 0;
		int [] uglyNumber = new int[index];
		uglyNumber[0] = 1;//ϰ�������ǳ�1Ϊ��һ������
		int multiBy2 = 0;
		int multiBy3 = 0;
		int multiBy5 = 0;
		for(int i=1;i<index;i++)
		{

			int min = min(uglyNumber[multiBy2]*2,uglyNumber[multiBy3]*3,uglyNumber[multiBy5]*5);
			uglyNumber[i] = min;
			if(uglyNumber[multiBy2]*2 <= min)
			{
				multiBy2++;
			}
			if(uglyNumber[multiBy3]*3 <= min)
			{
				multiBy3++;
			}
			if(uglyNumber[multiBy5]*5 <= min)
			{
				multiBy5++;
			}
			System.out.println(uglyNumber[i]+" "+multiBy2+" "+multiBy3+" "+multiBy5);
		}
		return uglyNumber[index-1];
	}
	public static int min(int num1,int num2,int num3)
	{
		int min = Math.min(num1, num2);
		return Math.min(min, num3);
	}
}
