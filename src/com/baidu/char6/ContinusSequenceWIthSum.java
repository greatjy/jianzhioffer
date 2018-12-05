package com.baidu.char6;


import java.util.ArrayList;

public class ContinusSequenceWIthSum
{
    public static void main(String[] args)
	{
		int sum = 15;
		ArrayList<ArrayList<Integer>> ans =  findoutsequence(sum);//findoutsequence(sum);
		for(ArrayList<Integer> arrayList : ans)
		{
			for(int i:arrayList)
			{
				System.out.print(i+"\t");
			}
			System.out.println();
		}
	}

	private static ArrayList<ArrayList<Integer>> findoutsequence(int sum)
	{
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		if(sum < 3)
			return ans;
		int small = 1;
		int big = 2;
		int middle = (1+sum)/2;
		int curSum = small + big;
		while(small < middle)
		{
			if(curSum == sum)
			{
				ArrayList<Integer> list = new ArrayList<>();
				for(int i= small;i<=big;i++)
				{
					list.add(i);
				}
				ans.add(list);
			}
			//int index = small;
			while(curSum > sum && small < middle)
			{
				curSum -= small;
				small++;
				if(curSum == sum)
				{
					ArrayList<Integer> list = new ArrayList<>();
					for(int i= small;i<=big;i++)
					{
						list.add(i);
					}
					ans.add(list);
				}
									
			}
			big++;
			curSum += big;
		}
		return ans;
	}
	
	private ArrayList<ArrayList<Integer>> getSequence(int sum)
	{
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = null;
		if(sum < 3)
			return ans;
		int small = 1;
		int big = 2;
		int mid = (sum+1)/2;
		int curSum = small+big;
		while(small < mid)
		{
			if(curSum == sum)
			{
				list = new ArrayList<>();
				for(int i= small;i<=big;i++)
				{
					list.add(i);
				}
				ans.add(list);
			}
			while(curSum > sum && small < mid)
			{
				curSum -= small;
				small++;
				if(curSum == sum)
				{
					list = new ArrayList<>();
					for(int i=small;i<=big;i++)
					{
						list.add(i);
					}
					ans.add(list);
				}
			}
			big++;
			curSum += big;

		}
		return ans;
		
	}
}
