/* 
Source: https://leetcode.com/problems/minimum-path-sum/description/
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
*/
public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        ans[0][0] = grid[0][0];
        for(int i = 1;i<m;i++)
            ans[0][i] = grid[0][i] + ans[0][i-1];
        for(int i = 1;i<n;i++)
            ans[i][0] = grid[i][0] + ans[i-1][0];
        for(int i = 1;i<n;i++)
            for(int j = 1;j<m;j++)
                ans[i][j] = Math.min(ans[i-1][j],ans[i][j-1]) + grid[i][j];
        return ans[n-1][m-1];
    }
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}