/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34981/assignment/problems/16/?navref=cl_pb_nv_tb
Source: 
Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Problem Constraints
1 <= length(A), length(B) <= 104

Example Input
Input 1:
 A = "aaa"
 B = "a*"
Input 2:
 A = "acz"
 B = "a?a"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.
Explanation 2:
 '?' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0.
*/
public class RegularExpressionMatch {
    static int[][] dp;
    public static boolean isAlphabet(char A)
    {
        if((A >= 'a' && A<='z') || (A>='A' && A<='Z'))
            return true;
        return false;
    }
    public static int regexMatch(String A, String B,int i, int j)
    {
        if(i < 0 && j < 0)
            return 1;
        if(j < 0)
            return 0;
        if(i < 0)
        {
            if(B.charAt(j)!='*')
                return 0;
            else
                return regexMatch(A,B,i,j-1);
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        if(isAlphabet(A.charAt(i)) && isAlphabet(B.charAt(j)))
        {
            if(A.charAt(i) == B.charAt(j))
                dp[i][j] = regexMatch(A,B,i-1,j-1);
            else
                dp[i][j] = 0;
        }
        if(isAlphabet(A.charAt(i)) && B.charAt(j) == '?')
            dp[i][j] = regexMatch(A,B,i-1,j-1);
        else if(isAlphabet(A.charAt(i)) && B.charAt(j) == '*')
        {
            dp[i][j] = Math.max(regexMatch(A,B,i-1,j),regexMatch(A,B,i,j-1));
        }
        return dp[i][j];
    }
    public static int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        dp = new int[n][m];
        for(int i = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                dp[i][j] = -1;
        return regexMatch(A,B,n-1,m-1);
    }
    public static void main(String[] args) {
        String A = new String("bcaccbabaa");
        String B = new String("bb*c?c*?");
        System.out.println(isMatch(A,B));
        for(int i = 0;i<A.length();i++)
        {
            for(int j = 0;j<B.length();j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
    }
}
/* 
Bottom Up 
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[2][m+1];
        dp[0][0] = 1;
        for(int i = 1;i<=m;i++)
            if(B.charAt(i-1) == '*')
                dp[0][i] = 1;
            else
                break;
        
        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=m;j++)
            {
                if(isAlphabet(A.charAt(i-1)) && isAlphabet(B.charAt(j-1)))
                {
                    if(A.charAt(i-1) == B.charAt(j-1))
                        dp[i%2][j] = dp[(i-1)%2][j-1];
                    else
                        dp[i%2][j] = 0;
                }
                else if(isAlphabet(A.charAt(i-1)) && B.charAt(j-1) == '?')
                    dp[i%2][j] = dp[(i-1)%2][j-1];
                else if(isAlphabet(A.charAt(i-1)) && B.charAt(j-1) == '*')
                {
                    dp[i%2][j] = Math.max(dp[(i-1)%2][j],dp[i%2][j-1]);
                }
            }
            dp[0][0] = 0;
        }
        return dp[n%2][m];
    }
*/
/* 
bcaccbabaa
bb*c?c*?

Expected: 0
*/