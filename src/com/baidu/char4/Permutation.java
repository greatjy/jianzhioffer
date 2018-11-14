package com.baidu.char4;

import java.util.ArrayList;

public class Permutation {
   public static void main(String[] args)
   {
	   String string = "abc";
	   System.out.println(permutation(string));
   }

   private static ArrayList<String> permutation(String str)
   {
	 ArrayList<String> res = new ArrayList<>();
     if(str == null)
         return res;
	return findPerm(str.toCharArray(),0,"",res);
   }

	private static ArrayList<String> findPerm(char[] str,int i, String temp, ArrayList<String> res) {
		// TODO Auto-generated method stub
		//System.out.println(temp+" "+str.toString());
		if(temp.length() == str.length)
		{
			res.add(temp);
		}
		for(int j=i;j<str.length;j++)
		{
			temp+=str[j];
			//交换第j位和第i位
			char swap = str[j];
			str[j] = str[i];
			str[i] = swap;			
			findPerm(str, i+1, temp, res);
			temp = temp.substring(0, temp.length()-1);
			char swap2 = str[i];
			str[i] = str[j];
			str[j] = swap;	
			
		}
		return res;
	}
}
