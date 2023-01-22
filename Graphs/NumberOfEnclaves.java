/* 
Source: https://leetcode.com/problems/number-of-enclaves/description/?envType=study-plan&id=graph-i
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
*/
public class NumberOfEnclaves {
    static int count = 0;
    static boolean offGrid = false;
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x < 0 || y < 0 || x >= n || y >= m)
            return false;
        return true;
    }
    static void dfs(int[][] grid,int x,int y,int n,int m)
    {
        count++;
        grid[x][y] = 2;
        int[] x_n = {1,-1,0,0};
        int[] y_n = {0,0,-1,1};
        for(int i = 0;i<4;i++)
        {
            int curr_x = x + x_n[i];
            int curr_y = y + y_n[i];
            if(!isValid(curr_x,curr_y,n,m))
                offGrid = true;
            if(isValid(curr_x,curr_y,n,m) && grid[curr_x][curr_y] == 1)
                dfs(grid,curr_x,curr_y,n,m);
        }
    }
    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int final_count = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    count = 0;
                    offGrid = false;
                    dfs(grid,i,j,n,m);
                    if(!offGrid)
                        final_count += count;
                }
            }
        }
        return final_count;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}
