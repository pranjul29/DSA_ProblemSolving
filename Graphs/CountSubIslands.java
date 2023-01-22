/* 
Source: https://leetcode.com/problems/count-sub-islands/description/?envType=study-plan&id=graph-i
You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.

An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.

Return the number of islands in grid2 that are considered sub-islands.

Example 1:

Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
Output: 3
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
Example 2:

Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
Output: 2 
Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.
 
Constraints:
m == grid1.length == grid2.length
n == grid1[i].length == grid2[i].length
1 <= m, n <= 500
grid1[i][j] and grid2[i][j] are either 0 or 1.
*/
public class CountSubIslands {
    static boolean notSubIsland = true;
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x < 0 || y < 0 || x >= n || y >= m)
            return false;
        return true;
    }
    static void dfs(int[][] grid1,int[][] grid2,int x,int y,int n,int m)
    {
        grid2[x][y] = 2;

        int[] x_n = {1,-1,0,0};
        int[] y_n = {0,0,-1,1};
        for(int i = 0;i<4;i++)
        {
            int curr_x = x + x_n[i];
            int curr_y = y + y_n[i];
            if(isValid(curr_x,curr_y,n,m) && grid1[curr_x][curr_y] == 0 && grid2[curr_x][curr_y] == 1)
                notSubIsland = false;
            if(isValid(curr_x,curr_y,n,m) && grid2[curr_x][curr_y] == 1)
                dfs(grid1,grid2,curr_x,curr_y,n,m);
        }
    }
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(grid2[i][j] == 1 && grid1[i][j] == 0)
                    continue;
                else if(grid2[i][j] == 1)
                {
                    notSubIsland = true;
                    dfs(grid1,grid2,i,j,n,m);
                    if(notSubIsland)
                        count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println(countSubIslands(grid1,grid2));
    }
}
