package com.baidu.char2;

import java.util.Scanner;

public class PowerSelf
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		double base = in.nextDouble();
		int exponent = in.nextInt();
		System.out.println(myPower(base,exponent));
	}

	private static double myPower(double base, int exponent)
	{
		// TODO 手动完成乘方函数 注意次数可能是0 和 负数  而且0的0次方 =1 0的负数次方 无意义
		boolean invalidFlag = false;
		if(Math.abs(base - 0.0)<1e-5 && exponent < 0)
		{
			invalidFlag = true;
			return 0.0;
		}
		if(exponent == 0)
		{
			return 1.0;
		}
		else if(exponent > 0)
		{
			return myPowerUE(base, exponent);
		}
		else if(exponent < 0)
		{
			return 1.0/myPowerUEII(base, -exponent);
		}
        return 0.0;
	}
	private static double myPowerUE(double base,int exp)
	{
		double ans = 1.0;
		for(int i=0;i<exp;i++)
		{
			ans *= base;
		}
		return ans;
	}
	private static double myPowerUEII(double base,int exp)
	{
		if(exp == 0)
			return 1.0;
		if(exp == 1)
			return base;
		double result = myPowerUEII(base, exp>>1);
		result *= result;
		if((exp & 1) == 1)
		{
			result *= base;
		}
		return result;
	}   
}
