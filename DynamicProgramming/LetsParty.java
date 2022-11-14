/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34969/homework/problems/1065/?navref=cl_pb_nv_tb
In Danceland, one person can party either alone or can pair up with another person.
Can you find in how many ways they can party if there are A people in Danceland?
Note: Return your answer modulo 10003, as the answer can be large.

Problem Constraints
1 <= A <= 10^5

Example Input
Input 1:
 A = 3
Input 2:
 A = 5

Example Output
Output 1:
 4
Output 2:
 26

Example Explanation
Explanation 1:
 Let suppose three people are A, B, and C. There are only 4 ways to party
 (A, B, C) All party alone
 (AB, C) A and B party together and C party alone
 (AC, B) A and C party together and B party alone
 (BC, A) B and C party together and A
 here 4 % 10003 = 4, so answer is 4.
Explanation 2:
 Number of ways they can party are: 26.
*/
import java.util.*;
public class LetsParty {
    static int[] dp;
    static int M = 10003;
    public static int party(int A)
    {
        if(A <= 2)
            return A;
        if(dp[A]!=-1)
            return dp[A];
        dp[A] = (party(A-1) + (party(A-2)*(A-1))%M)%M;
        return dp[A];
    }
    public static int solve(int A) {
        dp = new int[A+1];
        Arrays.fill(dp,-1);
        return party(A);
    }
    public static void main(String[] args) {
        int A = 10;
        System.out.println(solve(A));
    }
}
