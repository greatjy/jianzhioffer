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
    		//str 和 pattern 全部匹配到了终点
    		return true;
    	}
    	if(index1<str.length() && index2>=pattern.length())
    	{
    		//模式匹配完成，但是字符串还有 所以匹配失败
    		return false;
    	}
    	if(index2+1 < pattern.length() && pattern.charAt(index2+1) == '*')
    	{
    		//当前pattern的下一个字符串是*的时候
    		
    		//字符串匹配完毕
    		if(index1 >= str.length()) {
    			return isMatch(str, index1, pattern, index2+2);
    		}
    		else
    		{
    			if(pattern.charAt(index2) == str.charAt(index1) || pattern.charAt(index2) =='.')
    			{
    				//当前位置匹配 移动到下一个模式串 因为下一个模式串是 '*' 所以有多种可能
    				//分别是 之前元素出现 1次，多次，0次
    				return isMatch(str, index1+1, pattern, index2+2)    //1ci
    						|| isMatch(str, index1+1, pattern, index2)  //多次
    						|| isMatch(str, index1, pattern, index2+2);  //0ci
    			}
    			else
    			{
    				//当前位置不匹配 ，成功匹配的情况只有*取得时候
    				return isMatch(str, index1, pattern, index2+2);
    			}
    		}
    	}
    	
    	//当前元素的下一个 不是 *   
    	if(index1 >=str.length()) // pattern2 的index2 尚未走完成，并且index1 已经走完，那么返回false
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
        //递归的终点  ：ture 和 false  
        if(s >= str.length && p >= pattern.length)
        {
             return true;   
        }
        //模式走完了，但是模式串尚未匹配完成 返回false
        if(s < str.length && p>=pattern.length)
        {
            return false;
        }
        //出现下下一个字符是 *
        if(p+1 < pattern.length && pattern[p+1] == '*')
        {
            if(s >= str.length)
            {
                //字符串匹配完成 而模式串还有n*的情况 只有*=0 才可能匹配
                return isMatch(str,s,pattern,p+2);
            }
            else
            {
                //看当前元素是否匹配
                if(str[s] == pattern[p] || pattern[p] == '.')
                {
                    //*有三种情况 *=1 n 0
                    //等于0 的情况是 当前匹配的这个元素其实是和*后面的模式串匹配的
                    return isMatch(str,s+1,pattern,p+2) 
                        || isMatch(str,s+1,pattern,p)
                        || isMatch(str,s,pattern,p+2);
                }
                else
                {
                    //当前位置不匹配 只有*=0的情况
                    return isMatch(str,s,pattern,p+2);
                }
            }
        }
        //模式串的下下一个元素不是*
        if(s>=str.length)
        {
            return false;
        }
        else
        {
            if(str[s] == pattern[p] || pattern[p] == '.')
            {
                //遍历匹配下一位
                return isMatch(str,s+1,pattern,p+1);
            }
        }
        return false;        
    }
}
