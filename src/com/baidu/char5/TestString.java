package com.baidu.char5;

public class TestString
{
    public static void main(String[] args)
	{
		String string  = "\\u65b0\\u95fb\\u9605\\u8bfb";
		System.out.println(string);
		System.out.println(string.length());
		String ss = string.replace("\\\\u", "\\u");
		System.out.println(ss);
		String string2 = "\u65b0\u95fb\u9605\u8bfb";
		System.out.println(string2);
		System.out.println(ss.equals(string2));
        System.out.println(ss.length()+" "+string2.length());
        String ssString = unicodeToCn(string);
        System.out.println(ssString.equals(string2));
	}
    private static String unicodeToCn(String unicode)
    {
    	String[] strings = unicode.split("\\\\u");
    	String returnStr = "";
    	for(int i=1;i<strings.length;i++)
    	{
    		System.out.println(strings[i]);
    		returnStr += (char)(Integer.valueOf(strings[i],16).intValue());
    	}
    	return returnStr;
    }
}
