/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34985/assignment/problems/4441
Source: https://leetcode.com/problems/longest-palindromic-subsequence/
Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
You need to return the length of longest palindromic subsequence.

Problem Constraints
1 <= length of(A) <= 10^3

Example Input
Input 1:
 A = "bebeeed"
Input 2:
 A = "aedsead"

Example Output
Output 1:
 4
Output 2:
 5

Example Explanation
Explanation 1:
 The longest palindromic subsequence is "eeee", which has a length of 4.
Explanation 2:
 The longest palindromic subsequence is "aedea", which has a length of 5.
*/
public class LongestPalindromeSubsequence {
    static int[][] dp;
    public static int longestPalindromeSubsequence(String A,int i,int j)
    {
        if(i == j)
            return 1;
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(A.charAt(i) == A.charAt(j))
            dp[i][j] = longestPalindromeSubsequence(A,i+1,j-1) + 2;
        else
            dp[i][j] = Math.max(longestPalindromeSubsequence(A,i+1,j),longestPalindromeSubsequence(A,i,j-1));
        return dp[i][j];
    }
    public static int solve(String A) {
        int N = A.length();
        dp = new int[N][N];
        for(int i = 0;i<N;i++)
            for(int j = 0;j<N;j++)
                dp[i][j] = -1;
        return longestPalindromeSubsequence(A,0,N-1);
        
    }
    public static void main(String[] args) {
        String A = new String("bebeeed");
        System.out.println(solve(A));
    }
}
