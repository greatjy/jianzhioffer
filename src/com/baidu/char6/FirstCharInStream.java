package com.baidu.char6;

import java.util.LinkedList;
import java.util.Queue;


public class FirstCharInStream
{
    public static void main(String[] args)
	{
	    char[] str = "google".toCharArray();
	    for(char ch:str)
	    {
	    	Insert(ch);
	    	char ans = FirstAppearingOnce();
	    	System.out.println(ans);
	    }
	}
    
    public static Queue<Character> queue = new LinkedList<>();
    public static int[] data = new int[256];
    //Insert one char from stringstream
    public static void Insert(char ch)
    {
    	++data[ch-'\0'];
    	if(data[ch-'\0'] == 1)
    	{
    		queue.add(ch);
    	}
    }
  //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        while(!queue.isEmpty() && data[queue.peek()] >= 2)
        {
        	queue.poll();
        }
        if(queue.isEmpty())
        	return '#';
        return queue.peek();
    }
}
