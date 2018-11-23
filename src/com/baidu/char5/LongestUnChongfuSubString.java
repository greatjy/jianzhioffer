package com.baidu.char5;

import java.util.HashMap;
import java.util.HashSet;

public class LongestUnChongfuSubString
{
    public static void main(String[] args)
	{
		String s = "arabcacft";
		System.out.println(longestSubWithoutDup(s));
		System.out.println(lengthOfLongestSubstring(s));
	}

	private static int longestSubWithoutDup(String s)
	{
		if(s == null || s.length() == 0)
			return 0;
		int maxLength = 0;
		int curLength = 0;
		int[] pos = new int[26];
		for(int i=0;i<26;i++)
		{
			pos[i] = -1;//负数表示没有出现过这个字符
			
		}
		for(int i=0;i<s.length();i++)
		{
			int curChar = s.charAt(i)-'a';
			int prePos = pos[curChar];
			int distance = i - prePos;
			if(prePos <0 || distance > curLength)
			{
				curLength ++;
			}
			else
			{
				if(curLength >= distance)
				{
					maxLength = curLength;
				}
				curLength = distance;
			}
		}
		return  maxLength;
	}
	public static int lengthOfLongestSubstring(String s)
    {
        if(s == null || s.length() == 0)
            return 0;
       HashMap<Integer,Integer> prePos = new HashMap<>();
       int[] dp = new int[s.length()];
       dp[0] = 1;
       prePos.put(s.charAt(0)-'a',0);
       for(int i=1;i<s.length();i++)
       {
           int charNum = s.charAt(i)-'a';
           if(!prePos.containsKey(charNum))
           {
        	  
               dp[i] = dp[i-1]+1;
               prePos.put(s.charAt(i)-'a', i);
           }
           else
           {
               int distance = i - prePos.get(charNum);
               if(distance > dp[i-1])
               {
                   dp[i] = dp[i-1]+1;
               }
               else
               {
                   dp[i] = distance;
               }
               prePos.put(s.charAt(i)-'a', i);
           }
       }
       int max = dp[0];
       for(int i=1;i<s.length();i++)
       {
    	   //System.out.println(dp[i]+"dp"+i);
           if(dp[i] > max)
           {
               max = dp[i];
           }            
       }
       return max;
   }
}
