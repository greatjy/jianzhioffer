package com.baidu.char2;

public class RouteInRectangle
{
	public static void main(String[] args)
	{
        char[][] arr = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        String s = "tcsx";
        System.out.println(countWays(arr, s));
    }
	

	public static boolean countWays(char[][] arr, String s)
	{
		if (arr == null || s == null)
			return false;
		if (s.length() == 0)
			return true;
		int rows = arr.length;
		int cols = arr[0].length;
		if (rows < 1 || cols < 1)
			return false;
		boolean[][] visited = new boolean[rows][cols];
		int pathLength = 0;
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (hasPathCore(arr, i, j, s, pathLength, visited))
				{
					return true;
				}
			}
		}

		return false;
	}

	private static boolean hasPathCore(char[][] arr, int i, int j, String s, int pathLength, boolean[][] visited)
	{
		if (pathLength == s.length())
			return true;
		boolean hasPath = false;
		int rows = arr.length;
		int cols = arr[0].length;
		if (i < rows && i >= 0 && j >= 0 && j < cols && arr[i][j] == s.charAt(pathLength) 
				&& !visited[i][j])
		{
			pathLength++;
			visited[i][j] = true;

			hasPath =  hasPathCore(arr, i - 1, j, s, pathLength, visited)
					|| hasPathCore(arr, i + 1, j, s, pathLength, visited)
					|| hasPathCore(arr, i, j - 1, s, pathLength, visited)
					|| hasPathCore(arr, i, j + 1, s, pathLength, visited);
			if (!hasPath)
			{
				--pathLength;// 回退到上一个状态
				visited[i][j] = false;
			}
		}

		return hasPath;
	}
}
