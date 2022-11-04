/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34973/assignment/problems/9340/?navref=cl_pb_nv_tb
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.

Problem Constraints
1 <= A <= 1000
1 <= |B| <= 1000
1 <= B[i] <= 1000
1 <= C[i] <= 1000

Example Input
Input 1:
A = 10
B = [5]
C = [10]
Input 2:
A = 10
B = [6, 7]
C = [5, 5]

Example Output
Output 1:
 5
Output 2:
14

Example Explanation
Explanation 1:
Only valid possibility is to take the given item.
Explanation 2:
Take the second item twice.
*/
public class UnboundedKnapsack {
    static int[][] dp;
    public static int unboundKnapsack(int[] A,int[] B,int i,int C)
    {
        if(i == 0 || C == 0)
            return 0;
        if(dp[i][C]!=-1)
            return dp[i][C];
        int profit = unboundKnapsack(A,B,i-1,C);
        if(C-B[i-1] >= 0)
            profit = Math.max(profit,unboundKnapsack(A,B,i,C-B[i-1])+A[i-1]);
        
        dp[i][C] = profit;
        return dp[i][C];
    }
    public static int solve(int A, int[] B, int[] C) {
        int N = B.length;
        dp = new int[N+1][A+1];
        for(int i = 0;i<=N;i++)
        {
            for(int j = 0;j<=A;j++)
                dp[i][j] = -1;
        }
        return unboundKnapsack(B,C,N,A);
    }
    public static void main(String[] args) {
        int A = 10;
        int[] B = {6, 7};
        int[] C = {5, 5};
        System.out.println(solve(A,B,C));
    }
}
