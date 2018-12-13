package com.baidu.char6;

public class AddWithoutSize
{
   public static void main(String[] args)
   {
	    int n = 3;
	    int m = 5;
	    int ans = addNum(n,m);
	    System.out.println(ans);
   }

   private static int addNum(int n, int m)
   {
	  int sum = 0;
	  int carry = 0;
	  do
	  {
		  sum = n ^ m;//����λ�ļӷ�
		  carry = (n&m)<<1;
		  n = sum;
		  m = carry;
	  } 
	  while ( carry!=0);
	  return sum;
   }
}
