/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34981/assignment/problems/4438/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/longest-common-subsequence/
Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
You need to return the length of such longest common subsequence.

Problem Constraints
1 <= Length of A, B <= 1005

Example Input
Input 1:
 A = "abbcdgf"
 B = "bbadcgf"
Input 2:
 A = "aaaaaa"
 B = "ababab"

Example Output
Output 1:
 5
Output 2:
 3

Example Explanation
Explanation 1:
 The longest common subsequence is "bbcgf", which has a length of 5.
Explanation 2:
 The longest common subsequence is "aaa", which has a length of 3.
*/
public class LongestCommonSubsequence {
    static int[][] dp;
    public static int lcs(int i,int j,String A,String B)
    {
        if(i < 0 || j < 0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(A.charAt(i) == B.charAt(j))
        {
            dp[i][j] = 1 + lcs(i-1,j-1,A,B);
        }
        else
        {
            dp[i][j] = Math.max(lcs(i-1,j,A,B) , lcs(i,j-1,A,B));
        }
        return dp[i][j];
    }
    public static int longestCommonSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        dp = new int[n][m];
        for(int i = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                dp[i][j] = -1;
        return lcs(n-1,m-1,A,B);
    }
    public static void main(String[] args) {
        String A = new String("abbcdgf");
        String B = new String("bbadcgf");
        System.out.println(longestCommonSubsequence(A, B));
    }
}
