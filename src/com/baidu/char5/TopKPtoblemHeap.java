package com.baidu.char5;

class MinHeap
{
	    // �ѵĴ洢�ṹ - ����
		private int[] data;
		
		// ��һ�����鴫�빹�췽������ת����һ��С���� ���췽�� �����ĺ�������builedHep
		public MinHeap(int[] data)
		{
			this.data = data;
			buildHeap();
		}
		public int[] getData()
		{
			return data;
		}
		
		// ������ת������С��
		private void buildHeap()
		{
			// ��ȫ������ֻ�������±�С�ڻ���� (data.length) / 2 - 1 ��Ԫ���к��ӽ�㣬������Щ��㡣
			// *���������ͼ�У�������10��Ԫ�أ� (data.length) / 2 - 1��ֵΪ4��a[4]�к��ӽ�㣬��a[5]û��*
	        for (int i = (data.length) / 2 - 1; i >= 0; i--) 
	        {
	        	// ���к��ӽ���Ԫ��heapify
	            heapify(i);
	            for(int in : data)
	            {
	            	System.out.print(in+" ");
	            	
	            }
	            System.out.println();
	        }
	    }
		
		private void heapify(int i)
		{
			// ��ȡ���ҽ��������±�
	        int l = left(i);  
	        int r = right(i);
	        
	        // ����һ����ʱ��������ʾ ����㡢���㡢�ҽ������С��ֵ�Ľ����±�
	        int smallest = i;
	        
	        // �������㣬�������ֵС�ڸ�����ֵ
	        if (l < data.length && data[l] < data[i])  
	        	smallest = l;  
	        
	        // �����ҽ�㣬���ҽ���ֵС�����ϱȽϵĽ�Сֵ
	        if (r < data.length && data[r] < data[smallest])  
	        	smallest = r;  
	        
	        // ���ҽ���ֵ�����ڸ��ڵ㣬ֱ��return�������κβ���
	        if (i == smallest)  
	            return;  
	        
	        // �������ڵ�����ҽ������С���Ǹ�ֵ���Ѹ��ڵ��ֵ�滻��ȥ
	        swap(i, smallest);
	        
	        // �����滻�����������ᱻӰ�죬����Ҫ����Ӱ��������ٽ���heapify
	        heapify(smallest);
	    }
		
		// ��ȡ�ҽ��������±�
		private int right(int i)
		{  
	        return (i + 1) << 1;  
	    }   
	 
		// ��ȡ����������±�
	    private int left(int i) 
	    {  
	        return ((i + 1) << 1) - 1;  
	    }
	    
	    // ����Ԫ��λ��
	    private void swap(int i, int j) 
	    {  
	        int tmp = data[i];  
	        data[i] = data[j];  
	        data[j] = tmp;  
	    }
	    
	    // ��ȡ���е���С��Ԫ�أ���Ԫ��
	    public int getRoot()
	    {
	    	    return data[0];
	    }
	 
	    // �滻��Ԫ�أ�������heapify
		public void setRoot(int root)
		{
			data[0] = root;
			heapify(0);
		}

}
public class TopKPtoblemHeap
{
    public static void main(String[] args)
	{
		int[] nums  = {3,8,1,4,6,5,9,2,7};
		MinHeap heap = new MinHeap(nums);
		int[] data = heap.getData();
		for(int i:data)
		{
			System.out.println(i);
		}
		int [] ans = topK(nums, 4);
		for(int j : ans)
		{
			System.out.println(j+"max");
		}
		
	}
    
    public static int[] topK(int[] data,int k)
    {
    	// ��ȡK��Ԫ�ط���һ������topk��
    			int[] topk = new int[k]; 
    			for(int i = 0;i< k;i++)
    			{
    				topk[i] = data[i];
    			} 			
    			// ת������С��
    			MinHeap heap = new MinHeap(topk);
    			
    			// ��k��ʼ������data
    			for(int i= k;i<data.length;i++)
    			{
    				int root = heap.getRoot();
    				
    				// �����ݴ��ڶ�����С���������ڵ㣩ʱ���滻���еĸ��ڵ㣬��ת���ɶ�
    				if(data[i] > root)
    				{
    					heap.setRoot(data[i]);
    				}
    			}
    			
    			return topk;
    }
}
