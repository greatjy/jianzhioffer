package com.baidu.char6;

public class MyAtoi
{
    public static void main(String[] args)
	{
		String string = "+2147483647";
		String string2 = "123a";
		int n = atoi(string);
		int m = atoi(string2);
		System.out.println(n+" "+m);
	}
    public static int atoi(String string)
    {
    	if(string == null || string.length() == 0)
    		return 0;
    	String s = string.trim();
    	int flag = 1;
    	int j =0;
    	if(s.charAt(0) == '+')
    	{
    		j++;
    	}
    	else if(s.charAt(0) == '-')
    	{
    		j++;
    		flag = -1;
    	}
    	long sum = 0;
    	for(;j<string.length();j++)
    	{
    		if(s.charAt(j)>='0' && s.charAt(j)<='9')
    		{
    			sum = sum*10+(s.charAt(j)-'0');
    			if(sum*flag > Integer.MAX_VALUE) return 0;
    			else if(sum * flag < Integer.MIN_VALUE) return 0;
    		}
    		else
    		{
    			return  0;
    		}
    	}
    	sum = sum*flag;
    	return (int)(sum);
    }
}
