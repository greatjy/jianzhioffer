package com.baidu.char5;

public class DigitsInSequenceProblem
{
    public static void main(String[] args)
	{
	    int i = 191;
		System.out.println(findDigInSeq(i));
	}

	private static int findDigInSeq(int index)
	{
		if(index < 0)
		   return -1;//���д�0��ʼ��
		int digits = 1;
		while(true)
		{
			//Ѱ��λ���� ����һλ������
			int numbers = countOfIntegers(digits);
			if(index < numbers)
			{
				//�䵽����һdigits λ����  
				return digitsAtIndex(index,digits);
			}
			index -= digits*numbers;//ȥ����һ�����ֹ�ռ�ĳ��� 
			digits++;			
		}
	}

	//�ҵ�λ��֮�󷵻ؽ��
	private static int digitsAtIndex(int index, int digits)
	{
		int number = (int)(Math.pow(10, digits-1)+(index/digits));//��ʱ��index �Ѿ���ֻʣ����һλ�������ֳ�����
		int position = digits - index%digits;//����number�ĵڼ�λ
		//ע���Ǵӵ�0λ��ʼȡ�ģ��������ʱ���༸�����ӵڼ������ֿ�ʼ
		for(int i=1;i<position;i++)
		{
			number/=10;
		}
		return number % 10;//ȡ��λ
	}

	//��һλ���ܹ��������ٸ�����  1λ��10����2λ��90��,3λ��900��������
	private static int countOfIntegers(int digits)
	{
		if(digits == 1)
			return 10;
		return (int)(9*Math.pow(10, digits-1));
	}
}
