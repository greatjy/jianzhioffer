package com.baidu.char2;

public class FIbonacci
{ 
	public static void main(String[] args)
	{
		int n =10;
		System.out.println(fibo(n));
	}
	
	public static int fibo(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		if( n==2)
			return 2;
		int [] dp = new int[3];
		dp[0] = 1;
		dp[1] = 2;
		for(int i=3;i<=n;i++)
		{
			dp[(i-1)%3] = dp[(i-2)%3] + dp[(i-3)%3];
		}
		return dp[(n-1)%3];
	}

}
