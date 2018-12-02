package com.baidu.char6;

public class NumberAppearsOnce
{
    public static void main(String[] args)
	{
		int[] nums = {2,4,3,6,3,2,5,5};
		int[] ans = findOnce(nums);
		for(int i:ans)
		{
			System.out.println(i);
		}
		int[] array = {4,4,4,5};
		System.out.println(findNumsinTriple(array));
	}

	private static int[] findOnce(int[] nums)
	{
		int[] ans = new int[2];
		int resultOfXor = 0;
		for(int i=0;i<nums.length;i++)
		{
			resultOfXor ^= nums[i];
		}
		System.out.println(resultOfXor+"resultxor");
		int bit = findFirstBitOne(resultOfXor);
		System.out.println("bits"+bit);
		int num1 = 0;
		int num2 = 0;
		for(int i=0;i<nums.length;i++)
		{
			
			if(isBit1(nums[i],bit))
			{
				num1 ^= nums[i];
			}
			else
			{
				num2 ^= nums[i];
			}
		}
		ans[0] = num1;
		ans[1] = num2;		
		return ans;
	}

	private static boolean isBit1(int i, int bit)
	{
		int num = (int) Math.pow(2, bit-1);
		//System.out.println(i & num);
		//System.out.println(bit+" "+num+"bitandnum");
		return (!((i & num) == 0));
	}

	private static int findFirstBitOne(int resultOfXor)
	{
		//最右边出现1的次数 之前做过 和自己的-1 与以下 那个是消除最右边的1
		int index = 1;
		int bits  = 1;
		for(index = 1;index<32;index++)
		{
			if((resultOfXor & bits) != 0)
			{
				return index;
			}
			bits *= 2;
		}		
		return 0;
	}
	
	public static int findNumsinTriple(int[] nums)
	{
		int[] bits = new int[32];
		/*int bit = 1;
		for(int i=0;i<bits.length-1;i++)
		{
			bit = (int)(Math.pow(2, i));
			for(int j=0;j<nums.length;j++)
			{
				if((nums[j] & bit) != 0)
				{
					bits[i]++;
				}
			}
		}*/
		for(int i=0;i<nums.length;i++)
		{
			int bitmask = 1;
			for(int j=31;j>=0;j--)
			{
				int bit = nums[i] & bitmask;
				if(bit != 0)
				{
					bits[j]++;
				}
				bitmask = bitmask << 1;
			}
		}
		int result = 0;
		for(int i=0;i<32;i++)
		{
			result = result<<1;
			result += bits[i]%3;
		}
		return result;
	}
}
