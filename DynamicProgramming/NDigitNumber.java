/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34969/assignment/problems/368/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s-/
Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
Since the answer can be large, output answer modulo 1000000007

Problem Constraints
1 <= A <= 1000
1 <= B <= 10000

Input Format
First argument is the integer A
Second argument is the integer B

Output Format
Return a single integer, the answer to the problem

Example Input
Input 1:
 A = 2
 B = 4
Input 2:
 A = 1
 B = 3

Example Output
Output 1:
 4
Output 2:
 1

Example Explanation
Explanation 1:
 Valid numbers are {22, 31, 13, 40}
 Hence output 4.
Explanation 2:
 Only valid number is 3 
*/
public class NDigitNumber {
    static int[][] dp;
    static int M = 1000000007;
    public static int numberWithSumS(int A,int B)
    {
        if(B < 0)
            return 0;
        if(dp[A][B] != -1)
            return dp[A][B];
        if(A == 1 && B > 9)
            return 0;
        if(A == 1)
            return 1;
        if(B == 0)
            return 1;
            
        long number = 0;
        for(int i = 0;i<10;i++)
        {
            number += numberWithSumS(A-1,B-i);
            number = number%M;
        }
        dp[A][B] = (int)number;
        return (int)number;
    }
    public static int solve(int A, int B) {
        if(B == 0)
            return 0;
        dp = new int[A+1][B+1];
        for(int i = 0;i<=A;i++)
            for(int j = 0;j<=B;j++)
                dp[i][j] = -1;
        dp[A-1][B] = 0;
        return numberWithSumS(A,B);
    }
    public static void main(String[] args) {
        int A = 2;
        int B = 4;
        System.out.println(solve(A,B));
    }
}
