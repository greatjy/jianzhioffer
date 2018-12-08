package com.baidu.char6;

import java.util.function.IntPredicate;

public class ProbabilityOfTouzi
{
    public static void main(String[] args)
	{
	    int n = 6;
	    printProbability(n);
	}
    public static final int MAX_D = 6;
	private static void printProbability(int n)
	{
		// TODO Auto-generated method stub
		if(n<1)
			return;
		int[] prob1 = new int[n*MAX_D+1];
		int[] prob2 = new int[n*MAX_D+1];
		boolean flag = true; //表示当前是prob1 将要推出 prob2
		for(int i=1;i<=MAX_D;i++)
		{
			prob1[i] = 1;//第一次投骰子的情况
		}
		
		//从第二次开始就是fn = fn-1+...fn-6
		for(int k=2;k<=n;k++)
		{
			if(flag)
			{
				for(int i=0;i<k;i++)
				{
					prob2[i] = 0; //k次投骰子，不可能出现小于k的结果
				}
				for(int i=k;i<=MAX_D*k;i++)
				{
					prob2[i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
					for(int j=1;j<=i&&j<=MAX_D;j++)
					{
						prob2[i]+=prob1[i-j];   //对于所有合法的j i-j>0 并且j<6
					}
				}
			}
			else
			{
				for(int i=0;i<k;i++)
				{
					prob1[i] = 0; //k次投骰子，不可能出现小于k的结果
				}
				for(int i=k;i<=MAX_D*k;i++)
				{
					prob1[i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
					for(int j=1;j<=i&&j<=MAX_D;j++)
					{
						prob1[i]+=prob2[i-j];   //对于所有合法的j i-j>0 并且j<6
					}
				}
			}
			flag = !flag;
		}
		double total = Math.pow(MAX_D, n);
		for(int i=n;i<=n*MAX_D;i++)
		{
			if(flag)
			{
				double ratio = prob1[i]/total;
				System.out.println("sum:"+i+"ratio"+ratio);
			}
			else
			{
				double ratio = prob2[i]/total;
				System.out.println("sum:"+i+"ratio"+ratio);
			}
		}
	}
}
