/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34969/assignment/problems/8/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/unique-paths-ii/
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1

Example Input
Input 1:
 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:
 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]
Example Output
Output 1:
 2
Output 2:
 0

Example Explanation
Explanation 1:
 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}  
 So, the total number of unique paths is 2. 
Explanation 2:
 It is not possible to reach (n, m) from (1, 1). So, ans is 0.
*/
public class UniquePathsInAGrid {
    static int[][] dp;
    public static int findNumberOfPaths(int[][] A,int i,int j)
    {
        if(dp[i][j] != -1)
            return dp[i][j];
        else if(A[i][j] == 1)
            dp[i][j] = 0;
        else
            dp[i][j] = findNumberOfPaths(A,i-1,j) + findNumberOfPaths(A,i,j-1);
        return dp[i][j];
    }
    public static int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        dp = new int[n][m];
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
                dp[i][j] = -1;
        }
        int temp = 1;
        for(int i = 0;i<n;i++)
        {
            if(A[i][0] == 1)
                temp = 0;
            dp[i][0] = temp;
        }
        temp = 1;
        for(int i = 0;i<m;i++)
        {
            if(A[0][i] == 1)
                temp = 0;
            dp[0][i] = temp;
        }
        int ans = findNumberOfPaths(A,n-1,m-1);
        return ans;
    }
    public static void main(String[] args) {
        int[][] A = {{0, 0, 0}{0, 1, 0}{0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(A));
    }
}
