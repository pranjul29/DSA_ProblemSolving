/*
Source: https://www.interviewbit.com/problems/tushars-birthday-party/
Source: https://www.scaler.com/academy/mentee-dashboard/class/34973/homework/problems/385/?navref=cl_pb_nv_tb

As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).
NOTE:
Each dish is supposed to be eaten by only one person. Sharing is not allowed.
Each friend can take any dish unlimited number of times.
There always exists a dish with filling capacity 1 so that a solution always exists.

Problem Constraints
|A| <= 1000
|B| <= 1000
|C| <= 1000

Input Format
First Argument is vector A, denoting eating capacities
Second Argument is vector B, denoting filling capacities
Third Argument is vector C, denoting cost

Output Format
Return a single integer, the answer to the problem

Example Input
Input 1:
A = [2, 4, 6]
B = [2, 1, 3]
C = [2, 5, 3]
Input 2:
A = [2]
B = [1]
C = [2]

Example Output
Output 1:
12
Output 2:
4

Example Explanation
Explanation 1:
First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
So 2 + 2*2 + 3*2 = 12.
Explanation 2:
Only way is to take 2 dishes of cost 2, hence 4.
 */
import java.util.*;
public class TusharBirthdayParty {
    static int[][] dp;
    public static int knapsack(int[] capacity,int[] cost,int totalCapacity,int i)
    {
        if(totalCapacity == 0)
            return 0;
        if(i <= 0 && totalCapacity > 0)
            return 10000000;
        if(dp[i][totalCapacity]!=-1)
            return dp[i][totalCapacity];
        int ans = knapsack(capacity,cost,totalCapacity,i-1);
        if(totalCapacity >= capacity[i-1])
            ans = Math.min(knapsack(capacity,cost,totalCapacity - capacity[i-1],i) + cost[i-1],ans);
        dp[i][totalCapacity] = ans;
        return ans;
    }
    public static int solve(final int[] A, final int[] B, final int[] C) {
        int ans = 0;
        int N = B.length;
        int[] results = new int[1001];
        Arrays.fill(results,-1);
        int maximum_capacity = Integer.MIN_VALUE;
        for(int i = 0;i<A.length;i++)
        {
            maximum_capacity = Math.max(maximum_capacity,A[i]);
        }
        dp = new int[N+1][maximum_capacity+1];
        for(int i = 0;i<=N;i++)
            for(int j = 0;j<=maximum_capacity;j++)
                dp[i][j] = -1;
        for(int k = 0;k<A.length;k++)
        {
            if(results[A[k]]!=-1)
            {
                ans += results[A[k]];
            }
            else
            {
                int current_ans = knapsack(B,C,A[k],N);
                results[A[k]] = current_ans;
                ans += current_ans;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {2, 4, 6};
        int[] B = {2, 1, 3};
        int[] C = {2, 5, 3};
        System.out.println(solve(A,B,C));
    }
}
