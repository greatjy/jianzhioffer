package com.baidu.char5;

//�Լ�����һ����С�ѵĽṹ
public class MyMinHeap
{
    //�ײ��������������ʵ�ֵģ�����ʵ�Ͼ���һ����ȫ������
	private int[] data;

	public MyMinHeap(int[] data)
	{
		super();
		this.data = data;
		buildHeap(data);
	}

	private void buildHeap(int[] data)
	{
		// ���ݴ����������ʵ����С�ѵ�
		// �Ͷ�����һ���������һ���к��ӵĽڵ㿪ʼ���ȽϺͺ���֮��Ĵ�С��
		// �������С�ڸ��ף��򽻻����Ӻ͸��׽ڵ�
		for(int i=(data.length)/2-1;i>=0;i--)
		{
			//���һ���к��ӽڵ����ȫ������ ���±���� len/2-1 
			// ����ʱ 7 �� last = 2 ż��ʱ 8�� last = 3
			healpify(i);//������ڵ㿪ʼ����ڵ���е���
		}
		
	}
	private void healpify(int i)
	{
		int left = getLeft(i);
		int right = getRight(i);
		
		int smallerOfChildren = i;//��ǰ�ڵ㣬���ӽڵ�����С���Ǹ��ڵ�
		if(left < data.length && data[left]<data[i])
			smallerOfChildren = left;
		if(right<data.length && data[right]<data[smallerOfChildren])
			smallerOfChildren = right;
		
		if(i == smallerOfChildren)
		{
			return;
		}
		
		swap(i,smallerOfChildren);
		//���ڽ��������������ᱻӰ�죬����Ҫ����Ӱ��������ٴν���helpify 
		
		//��֤ÿһ���ڵ�ĸ��׶��Ⱥ���ҪС
		healpify(smallerOfChildren);//���������ٴ��γ�  �����ᱣ֤��С�Ľڵ�һ������������
	}
	
	public int getLeft(int i)
	{
		return (i+1)*2-1; //2�������� 5���к�����6
	}
	
	public  int getRight(int i)
	{
		return (i+1)*2;
	}
	
	public int getRoot()
	{
		return data[0];
	}
	private void swap(int i,int j)
	{
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	public void setRoot(int root)
	{
		data[0] = root; //ͷ�ڵ�����
		healpify(0);
	}
	
}
