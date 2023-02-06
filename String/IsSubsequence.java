/* 
Source: https://leetcode.com/problems/is-subsequence/description/?envType=study-plan&id=level-1
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 
Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
s and t consist only of lowercase English letters.
 
Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
*/
// TC: O(N) SC:O(1)
import java.util.*;
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int first_s = 0;
        int first_t = 0;
        int last_s = s.length()-1;
        int last_t = t.length()-1;
        while(first_s <= last_s && first_t <= last_t)
        {
            if(first_t == last_t && first_s != last_s)
                return false;
            if(s.charAt(first_s) == t.charAt(first_t))
            {
                first_s++;
                first_t++;
            }
            else
                first_t++;
            if(s.charAt(last_s) == t.charAt(last_t))
            {
                last_t--;
                last_s--;
            }
            else
                last_t--;
        }
        if(first_s > last_s)
            return true;
        return false;
    }
    public static void main(String[] args) {
        String s = new String("abc");
        String t = new String("ahbgdc");
        System.out.println(isSubsequence(s, t));
    }
}
