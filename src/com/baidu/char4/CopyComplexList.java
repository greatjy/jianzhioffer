package com.baidu.char4;


class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}

public class CopyComplexList {
	public static void main(String[] args) 
	{
         RandomListNode head = new RandomListNode(1);
         RandomListNode b = new RandomListNode(2);
         RandomListNode c = new RandomListNode(3);
         RandomListNode d = new RandomListNode(4);
         RandomListNode e = new RandomListNode(5);
         head.next = b;
         b.next = c;
         c.next = d;
         d.next = e;
         head.random = c;
         d.random = b;
         b.random = e;
         e.random = c;
         RandomListNode ans = Clone(head);
         RandomListNode ans2 = copy(head);
         printNode(ans);
         printNode(ans2);
	}
	public static RandomListNode copy(RandomListNode head)
    {
        cloneNodes(head);
		connectRandom(head);
		return splitNode(head);
    }
    private static RandomListNode splitNode(RandomListNode head) {
		// 分割两个链表 奇数是原来链表 偶数是复制链表
		
    	/*RandomListNode cloneHead = head.next;
		RandomListNode curr = head;
		RandomListNode cloneCurr = cloneHead;
		while(curr.next.next != null)
		{
			//curr 后面是dupcurr 不可能为空
			//但是cloneCurr 后面可能是空
			curr.next = curr.next.next;
			cloneCurr.next = cloneCurr.next.next;
			curr = curr.next;
			cloneCurr = cloneCurr.next;
		}
		return cloneHead;*/
    	
    	RandomListNode pNode = head;
    	RandomListNode pClone = head.next;
    	RandomListNode pcloneNode = head.next;
    	/*if(pNode != null)
    	{
    		//pclone 就是现在出现的复制节点的头节点，pcloneNode 是当前复制节点中的每一个节点
    		pClone = pcloneNode = pNode.next;
    		pNode.next = pcloneNode.next;
    		pNode = pNode.next;
    	}*/
    	while(pcloneNode.next != null)
    	{
    		//pClone = pNode.next;
    	
    		pNode.next = pcloneNode.next;
    		pNode = pNode.next;
    		pcloneNode.next = pNode.next;
    		pcloneNode = pcloneNode.next;
    		//System.out.println(pNode+" "+pcloneNode);
    	}
    	return pClone;
	}
    private static RandomListNode Split(RandomListNode pHead) {
        RandomListNode orign, cloneHead = null, clone = null;
        orign = pHead;
        if (orign != null) {
            cloneHead = orign.next;
            orign.next = cloneHead.next; 
            orign = cloneHead.next;
            clone = cloneHead;
        }
  
        while (orign != null) {
            RandomListNode temp = orign.next;
            orign.next = temp.next;
            orign = orign.next;
            clone.next = temp;
            clone = temp;
        }
  
        return cloneHead;
    }
    
    //connetRandom is also no problem
	private static void connectRandom(RandomListNode head) 
	{
		//复制节点在复制到节点next之后 要开始复制random了
		RandomListNode curr = head;
		while(curr != null)
		{
			RandomListNode rand = curr.random;
			RandomListNode dupcurr = curr.next;
			if(rand != null)
				dupcurr.random = rand.next;
			curr = dupcurr.next;
		}
	}
    /**
     * 
     * @param pHead
     */
    private static void ConstructSibling(RandomListNode pHead) {
        RandomListNode pre = pHead;
        RandomListNode clone;
        while (pre != null) {
            clone = pre.next;
            if (pre.random != null) {
                clone.random = pre.random.next;
            }
            pre = clone.next;
        }
    }
	
	
	//cloneNodes is a no problem function
	private static void cloneNodes(RandomListNode head) {
		RandomListNode curr = head;
		while(curr != null)
		{
			RandomListNode dupcurr = new RandomListNode(curr.label);
			RandomListNode next = curr.next;
			curr.next = dupcurr;
			dupcurr.next = next;
			curr = next; //递归
		}		
	}
    /**
     * 复制一份链表.<br>
     * 将链表中的每一个节点在自己的后面复制一个<br>
     * 原链表：1234 复制之后：11223344
     * 
     * @param pHead
     */
    private static void CloneList(RandomListNode pHead) {
        RandomListNode current = pHead;
        while (current != null) {
            RandomListNode temp = new RandomListNode(current.label);
            temp.next = current.next;
            temp.random = null;
            current.next = temp;
            current = temp.next;
        }
    }
    
    
    
	public static void printNode(RandomListNode head)
	{
		RandomListNode curr = head;
		while(curr != null)
		{
			System.out.print(curr.label);
			if(curr.random != null)
				System.out.println(" ++"+curr.random.label);
			else {
				System.out.println();
			}

			curr = curr.next;
		}
	}

	
	
	public static RandomListNode Clone(RandomListNode pHead) {
		  
        CloneList(pHead);
        ConstructSibling(pHead);
  
        return Split(pHead);
    }
  

  

  

}
