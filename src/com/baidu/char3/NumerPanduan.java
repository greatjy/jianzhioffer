package com.baidu.char3;

public class NumerPanduan
{
	    public static void main(String[] args)
		{
			char[] ans = "12e-".toCharArray();
			System.out.println(isNumeric(ans));
 		}
	    static int index;
	    public static boolean isNumeric(char[] str) 
	    {
	        if(str == null)
	        {
	            return false;
	        }
	        index = 0;
	        boolean res = true;
	        if(str[index] == '+' || str[index] == '-')
	        {
	            index++;
	        }
	        if(index == str.length)
	        {
	            return false;
	        }
	        scanDigits(str);//循环到下一个不为数字的字符
	        //判断这个字符到底是。还是e 其他字符返回false
	        if(index == str.length)
	        	return true;
	        if(str[index] == '.')
	        {
	            //小数可以没有整数部分 .123 = 0.123
	            //小数点后面可以没有数字 233. = 233.0
	            //当然小数点前后都可以有数字
	            index++;
	            scanDigits(str);
	            if(index == str.length)
	            	return true;
	            if(index <str.length && str[index] == 'E' || str[index] == 'e')
	            {
	                //判断是否是一个e行数字
	                res = isExp(str);
	            }
	            else
	            {
	                return false;
	            }
	        }
	        else if(str[index] =='e' || str[index] == 'E')
	        {
	            res = isExp(str);
	        }
	        else
	        { 
	            return false;
	        }
	        return res;
	    }
	    public static void scanDigits(char[] str)
	    {
	        while(index<str.length && str[index] >= '0' && str[index]<= '9')
	        {
	            index++;
	        }
	    }
	    public static boolean isExp(char[] str)
	    {
	        //e 前面不可以没有数字 e1 不符合
	        //e 后面没有数字是 1e 也不符合
	        index++;
	        if(index == str.length) return false;
	        if(str[index] == '+' || str[index] == '-')
	        {
	            index ++;
	        }
	        scanDigits(str);
	        return index == str.length;
	    }
	
} 
