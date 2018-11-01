package com.baidu.char3;

public class RegMatch
{
    public static void main(String[] args)
	{
		String string = "";
		String pattern = ".*";
		char[] str = "".toCharArray();
		char[] pattern1 = ".*".toCharArray();
		System.out.println(match(str, pattern1));
		if(string == null || pattern == null)
			System.out.println("false");
		//System.out.println(isMatch(string,0,pattern,0));
	}
    public static boolean isMatch(String str,int index1,String pattern,int index2)
    {
    	if(str.length() <= index1 && pattern.length() <= index2)
    	{
    		//str �� pattern ȫ��ƥ�䵽���յ�
    		return true;
    	}
    	if(index1<str.length() && index2>=pattern.length())
    	{
    		//ģʽƥ����ɣ������ַ������� ����ƥ��ʧ��
    		return false;
    	}
    	if(index2+1 < pattern.length() && pattern.charAt(index2+1) == '*')
    	{
    		//��ǰpattern����һ���ַ�����*��ʱ��
    		
    		//�ַ���ƥ�����
    		if(index1 >= str.length()) {
    			return isMatch(str, index1, pattern, index2+2);
    		}
    		else
    		{
    			if(pattern.charAt(index2) == str.charAt(index1) || pattern.charAt(index2) =='.')
    			{
    				//��ǰλ��ƥ�� �ƶ�����һ��ģʽ�� ��Ϊ��һ��ģʽ���� '*' �����ж��ֿ���
    				//�ֱ��� ֮ǰԪ�س��� 1�Σ���Σ�0��
    				return isMatch(str, index1+1, pattern, index2+2)    //1ci
    						|| isMatch(str, index1+1, pattern, index2)  //���
    						|| isMatch(str, index1, pattern, index2+2);  //0ci
    			}
    			else
    			{
    				//��ǰλ�ò�ƥ�� ���ɹ�ƥ������ֻ��*ȡ��ʱ��
    				return isMatch(str, index1, pattern, index2+2);
    			}
    		}
    	}
    	
    	//��ǰԪ�ص���һ�� ���� *   
    	if(index1 >=str.length()) // pattern2 ��index2 ��δ����ɣ�����index1 �Ѿ����꣬��ô����false
    		return false;
    	else
    	{
    		if(pattern.charAt(index2) == str.charAt(index1) || pattern.charAt(index2) =='.')
    		{
    			return isMatch(str, index1+1, pattern, index2+1);
    		}
    	}
		return false;
    }
    public static boolean match(char[] str, char[] pattern)
    {
        //author:omg_lionkk
        if(str == null || pattern == null)
        {
            return false;
        }
        return isMatch(str,0,pattern,0);
    }
    public static boolean isMatch(char[] str,int s,char[] pattern,int p)
    {
        //�ݹ���յ�  ��ture �� false  
        if(s >= str.length && p >= pattern.length)
        {
             return true;   
        }
        //ģʽ�����ˣ�����ģʽ����δƥ����� ����false
        if(s < str.length && p>=pattern.length)
        {
            return false;
        }
        //��������һ���ַ��� *
        if(p+1 < pattern.length && pattern[p+1] == '*')
        {
            if(s >= str.length)
            {
                //�ַ���ƥ����� ��ģʽ������n*����� ֻ��*=0 �ſ���ƥ��
                return isMatch(str,s,pattern,p+2);
            }
            else
            {
                //����ǰԪ���Ƿ�ƥ��
                if(str[s] == pattern[p] || pattern[p] == '.')
                {
                    //*��������� *=1 n 0
                    //����0 ������� ��ǰƥ������Ԫ����ʵ�Ǻ�*�����ģʽ��ƥ���
                    return isMatch(str,s+1,pattern,p+2) 
                        || isMatch(str,s+1,pattern,p)
                        || isMatch(str,s,pattern,p+2);
                }
                else
                {
                    //��ǰλ�ò�ƥ�� ֻ��*=0�����
                    return isMatch(str,s,pattern,p+2);
                }
            }
        }
        //ģʽ��������һ��Ԫ�ز���*
        if(s>=str.length)
        {
            return false;
        }
        else
        {
            if(str[s] == pattern[p] || pattern[p] == '.')
            {
                //����ƥ����һλ
                return isMatch(str,s+1,pattern,p+1);
            }
        }
        return false;        
    }
}
