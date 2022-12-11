/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34981/assignment/problems/9318/?navref=cl_pb_nv_tb

Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.

Problem Constraints
1 <= N <= 1000
0 <= A[i] <= 10^6

Input Format
First and only argument is an integer array A of size N.

Output Format
Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.

Example Input
Input 1:
 A = [3, 4, 1, 6, 2]
Input 2:
 A = [1, 5, 2, 5, 6]

Example Output
Output 1:
 15
Output 2:
 11

Example Explanation
Explanation 1:
 Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
Explanation 2:
 Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
*/
public class CuttingARod {
    static int[][] dp;
    public static int cutRod(int i,int length,int[] A)
    {
        if(i > A.length || length <= 0 || i > length)
            return 0;
        if(dp[i][length] != -1)
            return dp[i][length];
        int ans = cutRod(i+1,length,A);
        if(i <= length)
        {
            ans = Math.max(ans,cutRod(i,length-i,A) + A[i-1]);
        }
        dp[i][length] = ans;
        return ans;
    }
    public static int solve(int[] A) {
        int N = A.length;
        dp = new int[N+1][N+1];
        for(int i = 0;i<=N;i++)
            for(int j = 0;j<=N;j++)
                dp[i][j] = -1;
        cutRod(1,N,A);
        int ans = Integer.MIN_VALUE;
        for(int i = 1;i<=N;i++)
        {
            ans = Math.max(dp[i][N],ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {3, 4, 1, 6, 2};
        System.out.println(solve(A));
    }
}
