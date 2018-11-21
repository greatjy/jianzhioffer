package com.baidu.char5;

public class MaxPriceOfGift
{
    public static void main(String[] args)
	{
    	 int[][] values = {
                 {1, 2, 3},
                 {4, 5, 6},
                 {7, 8, 9}};
         System.out.println(getMaxPathValue(values));  //29
         int[][] values1 = {{1, 10, 3, 8}};
         System.out.println(getMaxPathValue(values1));  //22
         int[][] values2 = {
                 {1},
                 {1},
                 {5},
                 {3}};
         System.out.println(getMaxPathValue(values2));  //10

	}

	private static int getMaxPathValue(int[][] nums)
	{
		if(nums == null || nums.length == 0 || nums[0].length == 0)
			return 0;
		int[][] dp = new int[nums.length][nums[0].length];
		int rows = dp.length;
		int cols = dp[0].length;
		dp[0][0] = nums[0][0];
		for(int i = 0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				int maxleft = 0;
				int maxup = 0;
				if(i>0)
				{
					maxleft = dp[i-1][j];
				}
				if(j>0)
				{
					maxleft = dp[i][j-1];
				}
				dp[i][j] = Math.max(maxleft, maxleft)+nums[i][j];
			}
		}
		return dp[rows-1][cols-1];
	}
}
