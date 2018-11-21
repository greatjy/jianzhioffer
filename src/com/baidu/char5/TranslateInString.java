package com.baidu.char5;


public class TranslateInString
{
    public static void main(String[] args)
	{
		String n = "12258";
		System.out.println(transToString(n));
	}

	private static int transToString(String number)
	{
		//动态规划，dp【i】表示从这一位开始到最后一位可以有多少种处理方式
		if(Integer.parseInt(number) <= 0)
			return 0;
		int len = number.length();
		int[] dp = new int[number.length()];
		int count = 0;
		dp[len -1] = 1;
		for(int i=len-2;i>=0;i--)
		{
			count = dp[i+1];
			int digits1 = number.charAt(i)-'0';   //这一位
			int digits2 = number.charAt(i+1)-'0'; //前一位
			int connectNumber = digits1*10+digits2;
			if(connectNumber >= 10 && connectNumber <= 26)
			{
				if(i<len-2)
				{
					count+=dp[i+2];//这就像爬楼梯
				}
				else
					count+=1; //没得加了
				
			}
			dp[i] = count;
 		}
		count = dp[0];
		return count;
	}
}
