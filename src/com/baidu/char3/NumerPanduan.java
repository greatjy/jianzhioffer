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
	        scanDigits(str);//ѭ������һ����Ϊ���ֵ��ַ�
	        //�ж�����ַ������ǡ�����e �����ַ�����false
	        if(index == str.length)
	        	return true;
	        if(str[index] == '.')
	        {
	            //С������û���������� .123 = 0.123
	            //С����������û������ 233. = 233.0
	            //��ȻС����ǰ�󶼿���������
	            index++;
	            scanDigits(str);
	            if(index == str.length)
	            	return true;
	            if(index <str.length && str[index] == 'E' || str[index] == 'e')
	            {
	                //�ж��Ƿ���һ��e������
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
	        //e ǰ�治����û������ e1 ������
	        //e ����û�������� 1e Ҳ������
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
