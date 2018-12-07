package com.baidu.char6;

public class ReverseString
{
    public static void main(String[] args)
	{
		String string = "wonderful";//"I am a student.";
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
		reverse(str,0,str.length-1);
		int begin = 0;
		int end = 0;
		while(end<string.length())
		{
			//System.out.println("kaishi"+begin+" "+end);
			if(str[begin] == ' '&& str[end] == ' ')
			{
				begin++;
				end++;
			}
			else if(str[begin]!= ' '&&str[end] == ' '&&end<str.length-1)
			{
				//System.out.println(begin+" "+end);
				reverse(str, begin, end-1);
				//begin = end;
				end++;
				begin = end;
			}
			else if(end == str.length-1)
			{
				reverse(str, begin, end);
				end++;
			}
			else {
				end++;
			}
		}
		return new String(str);
		
	}
	private static void reverse(char[] str,int start,int end)
	{
		if(start <0 || end>str.length)
			return;
		while(start < end)
		{
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
}
