package com.baidu.char2;

public class Test
{
    public static void main(String[] args)
	{
		String string = "xxx.jpg";
		String newStr = "��������ַ���"+string.substring(string.lastIndexOf('.'));
		System.out.println(newStr);
	}
}
