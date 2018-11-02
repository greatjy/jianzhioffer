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
		//���ȼ������һ�α������ص�����
		//int start = 0;
		int endY = matrix.length-start-1;//ÿһ�ж�Ӧ����y
		int endX = matrix[0].length- start-1;//ÿһ�ж�Ӧ����x
		for(int i= start;i<=endX;i++)
		{
			System.out.println(matrix[start][i]);
		}
		
		if(endY > start)
		{
			//��ʼ���y���������ֹ�㲻��ͬһ�� �������±���
			for(int i=start+1;i<=endY;i++)
			{
				System.out.println(matrix[i][endX]);
			}
		}
		
		if(start < endY && start<endX)
		{
			//������һ����ͬʱ������������յ㲻��ͬһ��
			//���Է�����ű���
			for (int i = endX-1;i >=start; i--) 
			{
				System.out.println(matrix[endY][i]);
			}
		}
		
		if(start < endX && start<endY-1)
		{
			//�����ص�֮���������һ��
			for(int i=endY-1;i>=start+1;i--)//ע������ļ�һ
			{
				System.out.println(matrix[i][start]);
			}
		}
	}
}
