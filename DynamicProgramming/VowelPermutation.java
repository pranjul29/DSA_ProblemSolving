/*
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

1) Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
2) Each vowel 'a' may only be followed by an 'e'.
3) Each vowel 'e' may only be followed by an 'a' or an 'i'.
4) Each vowel 'i' may not be followed by another 'i'.
5) Each vowel 'o' may only be followed by an 'i' or a 'u'.
6) Each vowel 'u' may only be followed by an 'a'.

Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Example 3: 
Input: n = 5
Output: 68
 
Example 4: 
Input: n = 3
Output: 19

Example 5: 
Input: n = 4
Output: 35

Constraints:
1 <= n <= 2 * 10^4
*/
class Solution {
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n+1][5];
        int M = 1000000007;
        for(int i = 0;i<5;i++)
        {
            dp[1][i] = 1;
        }
        for(int i = 2;i<=n;i++)
        {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4])%M;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%M;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3])%M;
            dp[i][3] = dp[i-1][2]%M;
            dp[i][4] = (dp[i-1][2] + dp[i-1][3])%M;
        }
        return (int)((dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4])%M);
    }
}
public class VowelPermutation {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countVowelPermutation(4));
    }
}
