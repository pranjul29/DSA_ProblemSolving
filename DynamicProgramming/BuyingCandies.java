/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34973/homework/problems/9011/?navref=cl_pb_nv_tb
Rishik likes candies a lot. So, he went to a candy-shop to buy candies.
The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles, each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik can buy as many complete candy-packets as he wants but he can't buy a part of the packet.
Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?

Problem Constraints
1 <= N <= 700
1 <= A[i] <= 1000
1 <= B[i] <= 1000
1 <= C[i],D <= 1000

Input Format
First argument of input is an integer array A
Second argument of input is an integer array B
Third argument of input is an integer array C
Fourth argument of input is an integer D

Output Format
Return a single integer denoting maximum sweetness of the candies that he can buy

Example Input
Input 1:
 A = [1, 2, 3]
 B = [2, 2, 10]
 C = [2, 3, 9]
 D = 8
Input 2:
 A = [2]
 B = [5]
 C = [10]
 D = 99

Example Output
Output 1:
 10
Output 2:
 90

Example Explanation
Explanation 1:
 Choose 1 Packet of kind 1 = 1 Candy of 2 Sweetness = 2 Sweetness
 Choose 2 Packet of kind 2 = 2 Candy of 2 Sweetness = 8 Sweetness
Explanation 2:
 Buy 9 Packet of kind 1. 18 Candy each of 5 Sweetness = 90 Sweetness
*/
public class BuyingCandies {
    static int[][] dp;
    public static int maxSweetness(int i,int[] A,int[] B,int[] C,int D)
    {
        if(i < 0 || D <= 0)
            return 0;
        if(dp[i][D]!=-1)
            return dp[i][D];
        if(D >= C[i])
            dp[i][D] = Math.max(maxSweetness(i-1,A,B,C,D),maxSweetness(i,A,B,C,D-C[i]) + A[i]*B[i]);
        else
            dp[i][D] = maxSweetness(i-1,A,B,C,D);
        return dp[i][D];
    }
    public static int solve(int[] A, int[] B, int[] C, int D) {
        int N = A.length;
        dp = new int[N][D+1];
        for(int i = 0;i<N;i++)
            for(int j = 0;j<=D;j++)
                dp[i][j] = -1;
        return maxSweetness(N-1,A,B,C,D);
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 2, 10};
        int[] C = {2, 3, 9};
        int D = 8;
        System.out.println(solve(A, B, C, D));
    }
}
