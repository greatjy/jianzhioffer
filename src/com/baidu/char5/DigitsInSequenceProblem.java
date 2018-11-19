package com.baidu.char5;

public class DigitsInSequenceProblem
{
    public static void main(String[] args)
	{
	    int i = 191;
		System.out.println(findDigInSeq(i));
	}

	private static int findDigInSeq(int index)
	{
		if(index < 0)
		   return -1;//序列从0开始数
		int digits = 1;
		while(true)
		{
			//寻找位区域 在哪一位区域中
			int numbers = countOfIntegers(digits);
			if(index < numbers)
			{
				//落到了这一digits 位区中  
				return digitsAtIndex(index,digits);
			}
			index -= digits*numbers;//去掉上一个数字共占的长度 
			digits++;			
		}
	}

	//找到位区之后返回结果
	private static int digitsAtIndex(int index, int digits)
	{
		int number = (int)(Math.pow(10, digits-1)+(index/digits));//此时的index 已经是只剩下这一位区的数字长度了
		int position = digits - index%digits;//这是number的第几位
		//注意是从第0位开始取的，所以这个时候余几表明从第几个数字开始
		for(int i=1;i<position;i++)
		{
			number/=10;
		}
		return number % 10;//取个位
	}

	//这一位中总共包含多少个数字  1位数10个，2位数90个,3位数900个。。。
	private static int countOfIntegers(int digits)
	{
		if(digits == 1)
			return 10;
		return (int)(9*Math.pow(10, digits-1));
	}
}
