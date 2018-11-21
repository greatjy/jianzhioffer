package com.baidu.char5;


public class TranslateInString
{
    public static void main(String[] args)
	{
		String n = "1234";
		System.out.println(transToString(n));
		System.out.println(decodeWays(n));
	}

	private static int transToString(String number)
	{
		//��̬�滮��dp��i����ʾ����һλ��ʼ�����һλ�����ж����ִ���ʽ
		if(Integer.parseInt(number) <= 0)
			return 0;
		int len = number.length();
		int[] dp = new int[number.length()];
		int count = 0;
		dp[len -1] = 1;
		for(int i=len-2;i>=0;i--)
		{
			count = dp[i+1];
			int digits1 = number.charAt(i)-'0';   //��һλ
			int digits2 = number.charAt(i+1)-'0'; //ǰһλ
			int connectNumber = digits1*10+digits2;
			if(connectNumber >= 10 && connectNumber <= 26)
			{
				if(i<len-2)
				{
					count+=dp[i+2];//�������¥��
				}
				else
					count+=1; //û�ü���
				
			}
			dp[i] = count;
 		}
		count = dp[0];
		return count;
	}
	public static int decodeWays(String n)
	{
		int num = Integer.parseInt(n);
		if(num<0)
			return 0;
		int len = n.length();
		if(len == 1)
			return 1;
		if(len == 2)
		{
			if(isValid(Integer.parseInt(n)))
			{
				return 2;
			}
			else 
			{
				return 1;
			}
		}
		int[] dp = new int[n.length()];
		dp[0] = 1;
		dp[1] = isValid(Integer.parseInt(n.substring(0, 2))) ? 2 : 1;
		for(int i=2;i<len;i++)
		{
			if(isValid(Integer.parseInt(n.substring(i-1,i+1))))
			{
				//System.out.println("true"+n.substring(i-2,i));
				dp[i] = dp[i-1]+dp[i-2];
				//System.out.println(dp[i]+" "+i);
			}
			else
			{
				dp[i] = dp[i-1];
			}
			System.out.println(dp[i]);
		}
		return dp[len-1];	
			
	}
	public static boolean isValid(int n)
	{
		if(0<= n  && n <=25)
			return true;
		return false;
	}
}
