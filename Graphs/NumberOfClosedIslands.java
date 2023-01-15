/* 
Source: https://leetcode.com/problems/number-of-closed-islands/description/
Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.

Example 1:
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).
Example 2:
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1
Example 3:
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 
Constraints:
1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1
*/
public class NumberOfClosedIslands {
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x < 0 || y < 0 || x >= n || y >= m)
            return false;
        return true;
    }
    static void dfs(int[][] grid,int x,int y,int n,int m)
    {
        grid[x][y] = 2;
        int[] x_n = {1,-1,0,0};
        int[] y_n = {0,0,-1,1};
        for(int i = 0;i<4;i++)
        {
            int curr_x = x + x_n[i];
            int curr_y = y + y_n[i];
            if(isValid(curr_x,curr_y,n,m) && grid[curr_x][curr_y] == 0)
                dfs(grid,curr_x,curr_y,n,m);
        }
    }
    public static int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++)
        {
            if(grid[i][0] == 0)
                dfs(grid,i,0,n,m);
            if(grid[i][m-1] == 0)
                dfs(grid,i,m-1,n,m);
        }
        for(int i = 0;i<m;i++)
        {
            if(grid[0][i] == 0)
                dfs(grid,0,i,n,m);
            if(grid[n-1][i] == 0)
                dfs(grid,n-1,i,n,m);
        }
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 0)
                {
                    dfs(grid,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }
}
