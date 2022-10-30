/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34965/assignment/problems/278/?navref=cl_pb_nv_tb
Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
Note: You can choose more than 2 numbers.

Problem Constraints
1 <= N <= 20000
1 <= A[i] <= 2000

Example Input
Input 1:
 A = [   
        [1]
        [2]    
     ]
Input 2:
 A = [   
        [1, 2, 3, 4]
        [2, 3, 4, 5]    
     ]

Example Output
Output 1:
 2
Output 2:
 8

Example Explanation
Explanation 1:
 We will choose 2.
Explanation 2:
 We will choose 3 and 5.
*/
import java.util.*;
public class MaxSumWithoutAdjacentElements {
    static int[] dp;
    static int maxSum(int[] equivalent_A,int i)
    {
        if(i < 0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        dp[i] = Math.max(equivalent_A[i] + maxSum(equivalent_A,i-2),maxSum(equivalent_A,i-1));
        return dp[i];
    }
    public static int adjacent(int[][] A) {
        int[] equivalent_A = new int[A[0].length];
        for(int i = 0;i<A[0].length;i++)
        {
            equivalent_A[i] = Math.max(A[0][i],A[1][i]);
        }
        dp = new int[equivalent_A.length];
        Arrays.fill(dp,-1);
        dp[0] = equivalent_A[0];
        if(equivalent_A.length == 1)
            return dp[0];
        dp[1] = Math.max(equivalent_A[0],equivalent_A[1]);
        return maxSum(equivalent_A,equivalent_A.length-1);
    }
}

/* Bottom Up
    public int adjacent(int[][] A) {
        int[] equivalent_A = new int[A[0].length];
        for(int i = 0;i<A[0].length;i++)
        {
            equivalent_A[i] = Math.max(A[0][i],A[1][i]);
        }
        int first = equivalent_A[0];
        if(equivalent_A.length == 1)
            return first;
        int second = equivalent_A[1];
        for(int i = 2;i<equivalent_A.length;i++)
        {
            int temp = equivalent_A[i] + first;
            first = Math.max(first,second);
            second = temp;
        }
        return Math.max(first,second);
    }
*/
