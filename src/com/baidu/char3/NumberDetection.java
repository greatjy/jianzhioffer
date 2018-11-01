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
		// �����쳣
		if(str == null)
			return false;
		index = 0;
		//�ж��Ƿ������ſ�ͷ 
		if(str.charAt(index) == '+' || str.charAt(index) == '-')
		{
			index++;
		}
		if(index == str.length())
		{
			return false;//�ַ�����ֻ��һ��+-��
		}
		boolean numeric = true;
		scanDigit(str);//ѭ����str�г��ֵ�һ�����������ַ����ַ�
		if(index != str.length())
		{
			//���ַ����г����˳�������֮��������ַ�
			if(str.charAt(index) == '.')
			{
				index++;
				scanDigit(str);//�ٴα�������һ���������ֵĵط�
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
				//���ֵ��ַ��ǷǷ��ַ�
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
			return false; // e����û�����ַ���false
		}
		if(str.charAt(index)=='+' || str.charAt(index)=='-')
		{
			index++;
		}
		if(index == str.length())
		{
			//e����ֻ��һ��+-��
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
