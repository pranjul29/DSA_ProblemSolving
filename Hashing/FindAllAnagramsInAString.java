/* 
Source: https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
Constraints:

1 <= s.length, p.length <= 3 * 10^4
s and p consist of lowercase English letters.
*/
import java.util.*;
public class FindAllAnagramsInAString {
    static boolean isSame(int[] map1,int[] map2)
    {
        for(int i = 0;i<26;i++)
        {
            if(map1[i] != map2[i])
                return false;
        }
        return true;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        if(p.length() > s.length())
            return results;
        for(int i = 0;i<p.length();i++)
        {
            map1[p.charAt(i)-'a']++;
            map2[s.charAt(i)-'a']++;
        }
        if(isSame(map1,map2))
            results.add(0);
        int window = p.length();
        for(int i = window;i<s.length();i++)
        {
            map2[s.charAt(i) - 'a']++;
            map2[s.charAt(i-window) - 'a']--;
            if(isSame(map1,map2))
                results.add(i-window+1);
        }
        return results;
    }
    public static void main(String[] args) {
        String s = new String("cbaebabacd");
        String p = new String("abc");
        System.out.println(findAnagrams(s,p));
    }
}
