/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34981/assignment/problems/319/?navref=cl_pb_nv_tb
You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
NOTE:
Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).

Problem Constraints
1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000

Input Format
First argument is an integer array A representing the set.
Second argument is an integer B.

Output Format
Return an integer denoting the number of ways.

Example Input
Input 1:
 A = [1, 2, 3]
 B = 4
Input 2:
 A = [10]
 B = 10

Example Output
Output 1:
 4
Output 2:
 1

Example Explanation
Explanation 1:
 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3} 
Explanation 2:
 There is only 1 way to make sum 10.
*/
public class CoinChangeInfinite {
    static int[][] dp;
    static int mod = 1000007;
    public static int coinChange(int[] A,int B,int i)
    {
        if(i == 0)
            return 0;
        if(B == 0)
            return 1;
        if(dp[i][B] != -1)
            return dp[i][B];
        int ans = coinChange(A,B,i-1);
        if(A[i-1] <= B)
            ans += coinChange(A,B-A[i-1],i);
        ans = ans%mod;
        dp[i][B] = ans;
        return dp[i][B];
    }
    public static int coinchange2(int[] A, int B) {
        int N = A.length;
        dp = new int[N+1][B+1];
        for(int i = 0;i<=N;i++)
            for(int j = 0;j<=B;j++)
                dp[i][j] = -1;
        int ans = coinChange(A,B,N);
        for(int i = 0;i<=N;i++)
        {
            for(int j = 0;j<=B;j++)
            {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int B = 4;
        System.out.println(coinchange2(A,B));
    }
}
