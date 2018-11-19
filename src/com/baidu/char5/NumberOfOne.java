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
			//每一位开始遍历 出去自己哪一位的高位*10^i-1 +1*10^i(>1) =1 低位+1，0 不加
			high = num/(int)(Math.pow(10, i));  //除去低位剩下之前的数字
			temp = num%(int)(Math.pow(10, i));  //低位和低位之后的数字 临时变量
			curr = temp /(int)(Math.pow(10, i-1));//第i位数字 
			low = temp % (int)(Math.pow(10, i-1));//剩下的数字
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
			i++;//逐位递增 当high=0的时候 还能进行最后一轮的计算 比如23154 还能计算 0+1W
		}
		return total;
		
	}
}
