package com.baidu.char4;

import java.util.ArrayList;

public class Testprintrec 
{
	    //public static ArrayList<Integer> ans = new ArrayList<Integer>();
	    public static void main(String[] args) {
	    	/*
	    	int[][] matrix = new int[5][5];
			for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
				{
					matrix[i][j] = i*5+j+1;
					//System.out.println(matrix[i][j]);
					
				}
			}*/
	    	int [][] matrix = {{1,2},{3,4}};
			ArrayList ans = printMatrix(matrix);
			System.out.println(ans);

		}
	    public static ArrayList<Integer> printMatrix(int [][] matrix) 
	    {
	    	ArrayList<Integer> ans = new ArrayList<>();
	        if(matrix == null || matrix.length<=0 || matrix[0].length<=0)
	            return ans;
	        int start = 0;
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        while(start*2<rows && start*2 < cols)
	        {
	            printinclockwiseOnce(matrix,start,ans);
	            start++;
	        }
	        //System.out.println(ans);
	        return ans;
	    }
	    public static void printinclockwiseOnce(int[][] matrix,int start,ArrayList<Integer> ans)
	    {
	        //无条件第一行
	        int endX = matrix[0].length-1-start;
	        int endY = matrix.length - 1 - start;
	        for(int i= start;i<= endX;i++)
	        {
	            ans.add(matrix[start][i]);
	            
	        }
	        //System.out.println(ans+"heng1");
	        if(start < endY)
	        {
	            for(int i=start+1;i<=endY;i++)
	            {
	                ans.add(matrix[i][endX]);
	              
	            }
	           // System.out.println(ans+"shu1");
	            //。。。tomorrow morning
	        }
	        if(start < endX && start< endY)
	        {
	            for(int i=endX-1;i>= start;i--)
	            {
	                ans.add(matrix[endY][i]);
	           //     System.out.println(ans);	               
	            }
	            
	        }
	        if(start < endX && start < endY-1)
	        {
	            for(int i=endY-1;i>start;i--)
	            {
	                ans.add(matrix[i][start]);
	            //    System.out.println(ans);
	            }
	            
	        }
	    }
}
