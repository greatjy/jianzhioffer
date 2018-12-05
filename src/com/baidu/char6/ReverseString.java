package com.baidu.char6;

public class ReverseString
{
    public static void main(String[] args)
	{
		String string = "I am a student.";
		String anString = reverseStr(string);
		System.out.println(anString);
	}

	private static String reverseStr(String string)
	{
		if(string == null)
		{
			return null;
		}
		char[] str = string.toCharArray();
		reverse(str,0,str.length);
		int begin = 0;
		int end = 0;
		while(end<string.length())
		{
			if(str[begin] == ' '&& str[end] == ' ')
			{
				begin++;
				end++;
			}
			else if(str[begin]!= ' '&&str[end] == ' ')
			{
				reverse(str, begin, end-1);
			}
			else {
				end++;
			}
		}
		return str.toString();
		
	}
	private static void reverse(char[] str,int start,int end)
	{
		
	}
}
