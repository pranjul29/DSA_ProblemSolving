/* 
Source: https://leetcode.com/problems/where-will-the-ball-fall/
You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.
A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.

Example 1:
Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
Output: [1,-1,-1,-1,-1]
Explanation: This example is shown in the photo.
Ball b0 is dropped at column 0 and falls out of the box at column 1.
Ball b1 is dropped at column 1 and will get stuck in the box between column 2 and 3 and row 1.
Ball b2 is dropped at column 2 and will get stuck on the box between column 2 and 3 and row 0.
Ball b3 is dropped at column 3 and will get stuck on the box between column 2 and 3 and row 0.
Ball b4 is dropped at column 4 and will get stuck on the box between column 2 and 3 and row 1.
Example 2:
Input: grid = [[-1]]
Output: [-1]
Explanation: The ball gets stuck against the left wall.
Example 3:
Input: grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
Output: [0,1,2,3,4,-1]
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 100
grid[i][j] is 1 or -1.
*/
public class WhereWillTheBallFall {
    static int[][] dp;
    public static int willBallPass(int[][] grid,int i,int j)
    {
        if(j<0 || j >= grid[0].length)
            return -1;
        if(i >= grid.length)
            return j;
        if(dp[i][j]!=2)
            return dp[i][j];
        if(grid[i][j] == 1)
        {
            if((j == (grid[0].length-1)) || (grid[i][j+1] == -1))
                dp[i][j] = -1;
            else
                dp[i][j] = willBallPass(grid,i+1,j+1);
        }
        else
        {
            if((j == 0) || (grid[i][j-1] == 1))
                dp[i][j] = -1;
            else
                dp[i][j] = willBallPass(grid,i+1,j-1);
        }
        return dp[i][j];
        
    }
    public static int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int i = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                dp[i][j] = 2;
        int[] result = new int[m];
        for(int k = 0;k<m;k++)
            result[k] = willBallPass(grid,0,k);
        return result;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        System.out.println(findBall(grid));
    }
}
