/*
 * You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
 

Constraints:

1) 1 <= words1.length, words2.length <= 10^4
2) 1 <= words1[i].length, words2[i].length <= 10
3) words1[i] and words2[i] consist only of lowercase English letters.
4) All the strings of words1 are unique.
 */

import java.util.*;
public class WordSubsets {
    public static int[] count(String A)
    {
        int[] char_freq = new int[26];
        for(int i = 0;i<A.length();i++)
        {
            int c = A.charAt(i) - 97;
            char_freq[c]++;
        }
        return char_freq;
    }
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<String>();
        int[] bMaxCount = new int[26];
        for(int i = 0;i<words2.length;i++)
        {
            int[] count_b = count(words2[i]);
            for(int j = 0;j<26;j++)
            {
                bMaxCount[j] = Math.max(count_b[j],bMaxCount[j]);
            }
        }
        for(int i = 0;i<words1.length;i++)
        {
            int flag = 0;
            int[] count_a = count(words1[i]);
            for(int j = 0;j<26;j++)
            {
                if(count_a[j] < bMaxCount[j])
                {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                result.add(words1[i]);
        }
        return result;
    }
    public static void main(String[] args)
    {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        List<String> result = wordSubsets(words1,words2);
        
    }
}
