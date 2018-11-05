package com.baidu.char4;

import java.util.Stack;

public class StackPushPopOrder 
{
    public static void main(String[] args) {
		int[] pPush = {1,2,3,4,5};
		int[] pPop =  {4,3,5,1,2};
		boolean isOrder = isPopOrder(pPush,pPop);
		System.out.println(isOrder);
	}

	private static boolean isPopOrder(int[] pPush, int[] pPop) {
		if(pPush == null || pPop == null)
			return false;
		if(pPush.length == 0 || pPop.length == 0)
		{
			return false;
		}
		int len = pPush.length;
		Stack<Integer> helpStack = new Stack<Integer>();
		int start = 0;
		for(int i=0;i<len;i++)
		{
			while(helpStack.isEmpty() || helpStack.peek() != pPop[i])
			{
				//ѹ��helpջֱ������ջ��ջ��Ԫ�� ����Ҫ��ǰ����ջҪ������Ԫ��
				if(start >= len)
				{
					//û��ѹջ�� ˵����ѹջ����������Ԫ�ض�û�г�ջ�����е��Ǹ�Ԫ��
					return false;
				}
				//ѹջֱ��ջ��Ԫ�� ���ڼ���Ҫ������Ԫ�أ�δ��ջ��Ԫ�أ�
				helpStack.push(pPush[start++]);
			}
			//����ջ��
			helpStack.pop();
		}
		return true;
	}
}
