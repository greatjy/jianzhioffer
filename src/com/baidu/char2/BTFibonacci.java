package com.baidu.char2;

public class BTFibonacci
{
	public static void main(String[] args)
	{
        int n = 5;
        System.out.println(jumpFloor(n));
	}
    public static int jumpFloor(int n)
    {
    	return (int) Math.pow(2, n-1);
    }
	public static int JumpFloorII(int target)
	{
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;
		int[] dp = new int[target + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= target; i++)
		{
			for (int j = 1; j < i; j++)
			{
				dp[i] += dp[j];
			}
			dp[i]++;
		}
		return dp[target];
	}
}
