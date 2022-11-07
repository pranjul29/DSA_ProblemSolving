/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34969/assignment/problems/17/?navref=cl_pb_nv_tb
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.

Problem Constraints
1 <= M, N <= 500
-100 <= A[i] <= 100

Example Input
Input 1:
 A = [ 
       [-2, -3, 3],
       [-5, -10, 1],
       [10, 30, -5]
     ]
Input 2:
 A = [ 
       [1, -1, 0],
       [-1, 1, -1],
       [1, 0, -1]
     ]

Example Output
Output 1:
 7
Output 2:
 1

Example Explanation
Explanation 1:
 Initially knight is at A[0][0].
 If he takes the path RIGHT -> RIGHT -> DOWN -> DOWN, the minimum health required will be 7.
 At (0,0) he looses 2 health, so health becomes 5.
 At (0,1) he looses 3 health, so health becomes 2.
 At (0,2) he gains 3 health, so health becomes 5.
 At (1,2) he gains 1 health, so health becomes 6.
 At (2,2) he looses 5 health, so health becomes 1.
 At any point, the health point doesn't drop to 0 or below. So he can rescue the princess with minimum health 7.
Explanation 2:
 Take the path DOWN -> DOWN ->RIGHT -> RIGHT, the minimum health required will be 1.
*/
public class DungeonPrincess {
    static int[][] dp;
    public static int minHealth(int[][] A,int i,int j,int n,int m)
    {
        if(i == (n-1) && j == (m-1))
        {
            if(A[i][j] > 0)
                dp[i][j] = 1;
            else
                dp[i][j] = Math.abs(A[i][j]) + 1;
            return dp[i][j];
        }
        if(i >= n || j>=m)
            return Integer.MAX_VALUE;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(A[i][j] > 0)
        {
            int health = Math.min(minHealth(A,i+1,j,n,m),minHealth(A,i,j+1,n,m)) - A[i][j];
            if(health <= 0)
                health = 1;
            dp[i][j] = health;
        }
        else
        {
            dp[i][j] =  Math.min(minHealth(A,i+1,j,n,m),minHealth(A,i,j+1,n,m)) + Math.abs(A[i][j]);
        }
        return dp[i][j];
    }
    public static int calculateMinimumHP(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        dp = new int[n][m];
        for(int i = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                dp[i][j] = -1;
        return minHealth(A,0,0,n,m);
    }
    public static void main(String[] args) {
        int[][] A = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(A));
    }
}
