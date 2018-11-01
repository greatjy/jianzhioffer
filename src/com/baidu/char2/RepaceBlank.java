package com.baidu.char2;

public class RepaceBlank
{
    public static void main(String[] args)
	{
		String string  = "we are happy";
		System.out.println(replaceBlank(string));
	}
    public static String replaceBlank(String s)
    {
    	if(s.length() == 0)
    	{
    		return s;
    	}
    	int len = s.length();
    	int count = 0;
    	for(int i =0;i<len;i++)
    	{
    		if(s.charAt(i) == ' ')
    		  count++;
    	}
    	int newLen = len+2*count;
    	int j =1;
    	char[] str = new char[newLen];
    	for(int i = len-1;i>=0;i--)
    	{
    		if(s.charAt(i) != ' ')
    		{
    			str[newLen-j] = s.charAt(i);
    			j++;
    		}
    		else
    		{
    			str[newLen-j] = '0';
    			j++;
    			str[newLen-j] = '2';
    			j++;
    			str[newLen-j] = '%';
    			j++;
    		}
    	}
    	String string =String.copyValueOf(str);
    	return string;
    }
}
