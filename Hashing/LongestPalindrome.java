/* 
Source: https://leetcode.com/problems/longest-palindrome/description/
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 
Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
*/
import java.util.*;
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++)
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        int highest_odd = 0;
        int total = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            if(entry.getValue()%2 == 0)
                total += entry.getValue();
            else
            {
                highest_odd = 1;
                total += entry.getValue() - 1;
            }
        }
        return total + highest_odd;
    }
    public static void main(String[] args) {
        String s = new String("abccccdd");
        System.out.println(longestPalindrome(s));
    }
}
