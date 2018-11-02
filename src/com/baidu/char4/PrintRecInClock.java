package com.baidu.char4;

public class PrintRecInClock 
{
    public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				matrix[i][j] = i*5+j+1;
				//System.out.println(matrix[i][j]);
				
			}
		}
		printinclockwise(matrix);
	}

    private static void printinclockwise(int[][] matrix)
    {
    	if(matrix == null || matrix[0].length<=0 || matrix.length <= 0)
    	{
    		return;
    	}
    	int start = 0;
    	while(matrix[0].length > start*2 && matrix.length > start*2)
    	{
    		printinclockwiseOnce(matrix,start);
    		start++;
    	}
    }
	private static void printinclockwiseOnce(int[][] matrix,int start) {
		// TODO Auto-generated method stub
		//首先计算出这一次遍历的重点坐标
		//int start = 0;
		int endY = matrix.length-start-1;//每一行对应的是y
		int endX = matrix[0].length- start-1;//每一列对应的是x
		for(int i= start;i<=endX;i++)
		{
			System.out.println(matrix[start][i]);
		}
		
		if(endY > start)
		{
			//起始点的y纵坐标和终止点不再同一列 可以向下遍历
			for(int i=start+1;i<=endY;i++)
			{
				System.out.println(matrix[i][endX]);
			}
		}
		
		if(start < endY && start<endX)
		{
			//满足上一条的同时，起点横坐标和终点不再同一列
			//可以反向横着遍历
			for (int i = endX-1;i >=start; i--) 
			{
				System.out.println(matrix[endY][i]);
			}
		}
		
		if(start < endX && start<endY-1)
		{
			//起点和重点之间隔了至少一行
			for(int i=endY-1;i>=start+1;i--)//注意这里的加一
			{
				System.out.println(matrix[i][start]);
			}
		}
	}
}
