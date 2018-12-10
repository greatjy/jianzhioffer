package com.baidu.char6;

import java.util.Arrays;

public class ContinousCard
{
    public static void main(String[] args)
	{
        int[] cards = {2,3,4,6,0};
        System.out.println(isContinous(cards));
	}

	private static boolean isContinous(int[] cards)
	{
		int len = cards.length;
		Arrays.sort(cards);
		int zeroNumbers = 0;
		for(int i=0;i<cards.length&&cards[i]==0;i++)
		{
			zeroNumbers++;
		}
		int small = zeroNumbers;
		int big = small+1;
		int gap = 0;
		while(big<len)
		{
			//如果有对子，则不可能使顺子
			if(cards[big] == cards[small])
				return false;
			//计算gap
			gap+=cards[big] - cards[small]-1;
			small++;
			big++;
		}
		return gap>zeroNumbers ? false:true;
	}
}
