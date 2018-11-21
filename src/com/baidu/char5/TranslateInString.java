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
}
