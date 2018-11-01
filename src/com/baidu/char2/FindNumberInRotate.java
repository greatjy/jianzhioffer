package com.baidu.char2;

public class FindNumberInRotate
{
	public static void main(String[] args)
	{
		int[] arr = { 3, 4, 5, 1, 2 ,3};
		// Sstem.out.println(findMin(arr));
		System.out.println(minNumberInRotateArray(arr));
		System.out.println(minNumberInRotateArray1(arr));
	}

	public static int minNumberInRotateArray(int[] array)
	{
		if (array == null || array.length == 0)
		{
			return 0;
		}
		int p1 = 0;// ��ǰ������
		int p2 = array.length - 1;// �Ӻ���ǰ��
		int min = array[p1];// ���û������ת��ֱ�ӽ�array[0]��ֵ���أ�
		int mid = 0;
		// �����鷢����ת�ˣ�
		while (array[p1] >= array[p2])
		{
			// ������ָ���ߵ����ŵ�λ��ʱ��p2������С����
			if (p2 - p1 == 1)
			{
				min = array[p2];
				break;
			}
			mid = (p1 + p2) / 2;
			// ����м�λ�õ����ȵ���p1λ�õ����ֵ���P2λ�õ���
			if (array[p1] == array[mid] && array[p2] == array[mid])
			{
				min = minInorder(array, p1, p2);
			}
			if (array[p1] <= array[mid])// ���м�λ�õ���λ������1����p1�ߵ�mid��λ��
			{
				p1 = mid;
			} else if (array[p2] >= array[mid])// ���м�λ�õ���λ������2����p2�ߵ�mid��λ��
			{
				p2 = mid;
			}
		}
		return min;
	}

	private static int minInorder(int[] array, int p1, int p2)
	{
		int min = array[p1];
		for (int i = p1 + 1; i <= p2; i++)
		{
			if (min > array[i])
			{
				min = array[i];
			}
		}
		return min;
	}
	 public static int minNumberInRotateArray1(int [] array) 
	    {
	        if(array == null || array.length == 0)
	            return 0;
	        int left = 0;
	        int right = array.length-1;
	        int mid = 0;//�����û����ת������ ��ôֱ�ӷ��� array[0]
	        while(array[left]>=array[right])
	        {
	            //�����������ת
	            if(right - left == 1)
	            {
	                //�������������ְ��ŵ���� 
	                mid = right;
	                break;
	            }
	            mid = left+(right-left)/2;
	            if(array[right] == array[mid] && array[left] == array[mid])
	            {
	                return minInOrder(array);
	            }
	            else if(array[left]<=array[mid])
	            {
	                left = mid;
	            }
	            else if(array[right]>=array[mid])
	            {
	                right = mid;
	            }            
	        }
	        return array[mid];
	    }
	    public static int minInOrder(int[] array)
	    {
	        int min = array[0];
	        for(int i=0;i<array.length;i++)
	        {
	            if(array[i]<min)
	            {
	                min = array[i];
	            }
	        }
	        return min;
	    }
}
