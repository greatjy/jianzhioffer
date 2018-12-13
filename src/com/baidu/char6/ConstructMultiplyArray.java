package com.baidu.char6;

public class ConstructMultiplyArray
{
    public static void main(String[] args)
	{
	    int [] A = {1,2,3,4,5,6,7,8,9};
	    int[] B = findMultiArray(A);
	    for(int i : B)
	    {
	    	System.out.println(i);
	    }
	}

	private static int[] findMultiArray(int[] a)
	{
        int len = a.length;
        int[] B = new int[len];
        int[] forward = new int[len];
        int[] backward = new int[len];
        forward[0] = backward[0] = 1;
        for(int i=1;i<len;i++)
        {
        	forward[i] = forward[i-1]*a[i-1];
        	backward[i] = a[len-i]*backward[i-1];
        }
        for(int i=0;i<len;i++)
        {
        	B[i] = forward[i]*backward[len-i-1];
        }
        return B;
 	}
}
