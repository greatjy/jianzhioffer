package com.baidu.char2;

import javax.swing.InputMap;

public class RobotsMoveRange
{
    public static void main(String[] args)
	{
		int threshold = 15;
		int n= 100;
		int m = 1;
		System.out.println(movingCount(threshold, n, m));
	}
    /*
    public static int count = 0;
    public static int movingCount(int threshold,int rows,int cols)
    {
    	if(rows <= 0  || cols <= 0 || threshold <0)
    		return 0;
    	int[][] visited = new int[rows][cols];
    	moveCount(threshold,rows,cols,0,0,visited);
    	return count;
    }
    private static void moveCount(int threshold, int rows, int cols, int i, int j, int[][] visited)
	{
		if(i>=0 && i<rows && j>=0 && j<cols && getSum(i)+getSum(j)<= threshold && visited[i][j] == 0)
		{
		    visited[i][j] = 1;
			count++;
			moveCount(threshold, rows, cols, i+1, j, visited);
			moveCount(threshold, rows, cols, i-1, j, visited);
			moveCount(threshold, rows, cols, i, j-1, visited);
			moveCount(threshold, rows, cols, i, j+1, visited);
		}
		return;
	}
	*/
	public static int movingCount(int threshold,int n, int m)
    {
    	//边界处理
    	if(threshold < 0 || n<=0 || m<=0)
    	{
    		return 0;
    	}
    	
    	//定义visited数组标记走过了的情况
    	boolean[] visited = new boolean[m*n];
    	
    	//调用递归函数来实现可走路径的统计 从0 ，0 位置开始遍历 看能够找到多少种情况 
    	int count = movingCountCore(threshold,n,m,0,0,visited);
    	return count;    	
    }
	private static int movingCountCore(int threshold, int n, int m, int i, int j, boolean[] visited)
	{
		int count =0;
		if(check(threshold,n,m,i,j,visited))//如果当前的位置走过
		{//System.out.println(i);
		//System.out.println(j);
			visited[i*m+j] = true;//标记当前位置已经走过
			count = 1 + movingCountCore(threshold, n, m, i+1, j, visited)
			+  movingCountCore(threshold, n, m, i-1, j, visited)
			+  movingCountCore(threshold, n, m, i, j+1, visited)
			+  movingCountCore(threshold, n, m, i, j-1, visited);
		}
		return count;
	}
	
	private static boolean check(int threshold,int n,int m,int i,int j,boolean[] visited)
	{
		if(i>=0 && i<n && j>=0 && j<m && getSum(i)+getSum(j)<= threshold && !visited[i*m+j])
			return true;
		else
			return false;
	}
	
	private static int getSum(int n)
	{
		int sum = 0;
		while(n>0)
		{
			sum+= n%10;
			n = n/10;
		}
		return sum;
	}
}
