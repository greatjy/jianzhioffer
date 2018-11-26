package com.baidu.char5;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstNodupChar
{
    public static void main(String[] args)
	{
		String string = "abaccdeff";
		System.out.println(firstWithoutDup(string));
		
	}

	public static int firstWithoutDup(String str)
	{
		if(str == null || str.length() == 0)
			return -1;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++)
		{
			if(!map.containsKey(str.charAt(i)))
			{
				map.put(str.charAt(i), 1);
			}
			else
			{
				map.put(str.charAt(i),map.get(str.charAt(i))+1);
			}
		}
		for(int i=0;i<str.length();i++)
		{
			if(map.get(str.charAt(i)) == 1)
				return i;
		}
		return -1;
	}
	public static Character firstWithOutDup(String str)
	{
		if(str == null)
			return null;
		char[] strChar = str.toCharArray();
		LinkedHashMap<Character,Integer> hash = new LinkedHashMap<Character,Integer>();
		for(char item:strChar){
			if(hash.containsKey(item))
				hash.put(item, hash.get(item)+1);
			else
				hash.put(item, 1);
		}
		for(char key:hash.keySet())
		{
			if(hash.get(key)== 1)
				return key;
		}
		return null;
	}
}
