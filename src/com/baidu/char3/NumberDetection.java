package com.baidu.char3;

public class NumberDetection
{
	static int index = 0;
    public static void main(String[] args)
	{
		String string = "123.45e+";
		System.out.println(isNumeric(string));
	}

	private static boolean isNumeric(String str)
	{
		// 输入异常
		if(str == null)
			return false;
		index = 0;
		//判断是否正负号开头 
		if(str.charAt(index) == '+' || str.charAt(index) == '-')
		{
			index++;
		}
		if(index == str.length())
		{
			return false;//字符串中只有一个+-号
		}
		boolean numeric = true;
		scanDigit(str);//循环到str中出现第一个不是数字字符的字符
		if(index != str.length())
		{
			//在字符串中出现了除了数字之外的其他字符
			if(str.charAt(index) == '.')
			{
				index++;
				scanDigit(str);//再次遍历到下一个不是数字的地方
				if(index < str.length() && str.charAt(index) == 'e' || str.charAt(index)=='E')
				{
					numeric = isExp(str);
				}				
			}
			else if(str.charAt(index) == 'e' || str.charAt(index) == 'E')
			{
				numeric = isExp(str);
			}
			else
			{
				//出现的字符是非法字符
				return false;
			}
		}
		return numeric && index == str.length();
	}
	
	private static boolean isExp(String str)
	{
		if(str.charAt(index)!= 'e' && str.charAt(index)!='E')
		{
			return false;
		}
		index++;
		if(index == str.length())
		{
			return false; // e后面没有数字返回false
		}
		if(str.charAt(index)=='+' || str.charAt(index)=='-')
		{
			index++;
		}
		if(index == str.length())
		{
			//e后面只有一个+-号
			return false;
		}
		scanDigit(str);
		return index == str.length() ? true :false;
	}

	private static void scanDigit(String str)
	{
		while(index<str.length() && str.charAt(index)>='0' && str.charAt(index)<='9')
		{
			index++;
		}
		
	}

	private static boolean isNumeric2(String string)
	{
		return string.matches("[\\+-]?[0-9]+(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
	}
}
