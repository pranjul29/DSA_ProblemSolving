/* 
Source: https://leetcode.com/problems/max-area-of-island/description/
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/
public class MaxAreaOfIsland {
    static int max_area = 0;
    static int count = 0;
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x < 0 || y < 0 || x >= n || y >= m)
            return false;
        return true;
    }
    static void dfs(int[][] grid,int x,int y,int n,int m)
    {
        // System.out.println(x + " " + y);
        count++;
        grid[x][y] = 2;
        max_area = Math.max(count,max_area);
        int[] x_n = {1,-1,0,0};
        int[] y_n = {0,0,-1,1};
        for(int i = 0;i<4;i++)
        {
            int curr_x = x + x_n[i];
            int curr_y = y + y_n[i];
            if(isValid(curr_x,curr_y,n,m) && grid[curr_x][curr_y] == 1)
                dfs(grid,curr_x,curr_y,n,m);
        }
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    dfs(grid,i,j,n,m);
                    count = 0;
                    // System.out.println(max_area);
                }
            }
        }
        return max_area;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
