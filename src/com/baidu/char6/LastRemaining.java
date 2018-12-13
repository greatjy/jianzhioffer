package com.baidu.char6;

public class LastRemaining
{
    public static void main(String[] args)
	{
    	int n = 5;
    	int k = 3;
		System.out.println(findJosephNumber(n,k));
	}

	private static int findJosephNumber(int n, int k)
	{
		// TODO Auto-generated method stub
		if(k<1 || n<1)
			return -1;
		if(n == 1)
			return k;
		int lastLoc = 0;
		for(int i=2;i<=n;i++)
		{
			lastLoc = (lastLoc + k)%i;
		}
		return lastLoc;
	}
}
