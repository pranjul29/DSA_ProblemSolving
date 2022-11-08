/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34981/assignment/problems/21
Source: https://leetcode.com/problems/edit-distance/
Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character

Problem Constraints
1 <= length(A), length(B) <= 450

Example Input
Input 1:
 A = "abad"
 B = "abac"
Input 2:
 A = "Anshuman"
 B = "Antihuman

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Exlanation 1:
 A = "abad" and B = "abac"
 After applying operation: Replace d with c. We get A = B.
Explanation 2:
 A = "Anshuman" and B = "Antihuman"
 After applying operations: Replace s with t and insert i before h. We get A = B.
*/
public class EditDistance {
    static int[][] dp;
    public static int editDistance(int i,int j,String A,String B)
    {
        if(i < 0 && j < 0)
            return 0;
        if(i < 0 || j < 0)
            return Math.max(i+1,j+1);
        if(dp[i][j] != -1)
            return dp[i][j];
        if(A.charAt(i) == B.charAt(j))
            dp[i][j] = editDistance(i-1,j-1,A,B);
        else
            dp[i][j] = Math.min(Math.min(editDistance(i-1,j-1,A,B),editDistance(i,j-1,A,B)),editDistance(i-1,j,A,B)) + 1;
        return dp[i][j];
    }
    public static int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        dp = new int[n][m];
        for(int i = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                dp[i][j] = -1;
        return editDistance(n-1,m-1,A,B);
    }
    public static void main(String[] args) {
        String A = new String("Anshuman");
        String B = new String("Antihuman");
        System.out.println(minDistance(A,B));
    }
}
