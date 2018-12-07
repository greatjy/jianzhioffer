package com.baidu.char6;

public class LeftRotate
{
    public static void main(String[] args)
	{
		String string = "abcXYZdef";
		String ans = leftRotateString(string,3);
		System.out.println(ans);
	}

	private static String leftRotateString(String string, int k)
	{
		if(string == null || string.length() == 0)
			return string;
		char[] str = string.toCharArray();
		reverseString(str,0,str.length-1);
		reverseString(str,str.length-k,str.length-1);
		reverseString(str,0,str.length-1-k);
		return new String(str);
	}

	private static void reverseString(char[] str, int left, int right)
	{
		// TODO Auto-generated method stub
		if(str == null || str.length == 0)
			return;
		if(left >= right)
			return;
		while(left < right)
		{
			char temp = str[left];
			str[left] = str[right];
			str[right] = temp;
			left++;
			right--;
		}		
	}
}
