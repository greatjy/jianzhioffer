package com.baidu.char5;

public class NumberOfOne
{
    public static void main(String[] args)
	{
		int num = 21354;
		System.out.println(numberOf1(num));
	}

	private static int numberOf1(int num)
	{
		if(num<0)
			return 0;
		int curr = 0,
		low =0,
		high = num,
		temp = 0,
		i=1,
		total = 0;
		while(high != 0)
		{
			//ÿһλ��ʼ���� ��ȥ�Լ���һλ�ĸ�λ*10^i-1 +1*10^i(>1) =1 ��λ+1��0 ����
			high = num/(int)(Math.pow(10, i));  //��ȥ��λʣ��֮ǰ������
			temp = num%(int)(Math.pow(10, i));  //��λ�͵�λ֮������� ��ʱ����
			curr = temp /(int)(Math.pow(10, i-1));//��iλ���� 
			low = temp % (int)(Math.pow(10, i-1));//ʣ�µ�����
			if(curr == 1)
			{
				total += high*(int)(Math.pow(10, i-1)) +low +1;
			}
			else if(curr == 0) 
			{
				total += high*(int)(Math.pow(10, i-1));
			}
			else {
				total += (high+1)*(int)(Math.pow(10, i-1));
			}
			i++;//��λ���� ��high=0��ʱ�� ���ܽ������һ�ֵļ��� ����23154 ���ܼ��� 0+1W
		}
		return total;
		
	}
}
