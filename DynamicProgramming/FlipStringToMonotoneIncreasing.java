/* 
Source: https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

Example 1:
Input: s = "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:
Input: s = "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
Example 3:
Input: s = "00011000"
Output: 2
Explanation: We flip to get 00000000.
 
Constraints:
1 <= s.length <= 10^5
s[i] is either '0' or '1'.
*/
public class FlipStringToMonotoneIncreasing {
    static int[][] dp;
    static int flipChoice(int index,int gotOneAlready,String s)
    {
        if(index >= s.length())
            return 0;
        if(dp[index][gotOneAlready]!= -1)
            return dp[index][gotOneAlready];
        if(s.charAt(index) == '0' && gotOneAlready == 0)
            dp[index][gotOneAlready] = Math.min(flipChoice(index+1,gotOneAlready,s), 1 + flipChoice(index+1,1,s));
        else if(s.charAt(index) == '0' && gotOneAlready == 1)
            dp[index][gotOneAlready] = flipChoice(index+1,gotOneAlready,s) + 1;
        else if(s.charAt(index) == '1' && gotOneAlready == 0)
            dp[index][gotOneAlready] = Math.min(flipChoice(index+1,gotOneAlready,s) + 1,flipChoice(index+1,1,s));
        else
            dp[index][gotOneAlready] = flipChoice(index+1,gotOneAlready,s);
        return dp[index][gotOneAlready];
    }
    public static int minFlipsMonoIncr(String s) {
        dp = new int[s.length()][2];
        for(int i = 0;i<s.length();i++)
            for(int j = 0;j<2;j++)
                dp[i][j] = -1;
        return flipChoice(0,0,s);
    }
    public static void main(String[] args) {
        String s = new String("00011000");
        System.out.println(minFlipsMonoIncr(s));
    }
}
