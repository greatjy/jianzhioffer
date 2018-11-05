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
				//压入help栈直到辅助栈的栈顶元素 等于要当前弹出栈要弹出的元素
				if(start >= len)
				{
					//没得压栈了 说明把压栈序列中所有元素都没有出栈序列中的那个元素
					return false;
				}
				//压栈直到栈顶元素 等于即将要弹出的元素（未入栈的元素）
				helpStack.push(pPush[start++]);
			}
			//弹出栈顶
			helpStack.pop();
		}
		return true;
	}
}
