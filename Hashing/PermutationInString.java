/*
Source: https://leetcode.com/problems/permutation-in-string/
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 
Constraints:
1 <= s1.length, s2.length <= 10^4
s1 and s2 consist of lowercase English letters.
*/
import java.util.*;
public class PermutationInString {
    public static boolean checkInclusion(String A, String B) {
        if(B.length()<A.length())
            return false;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<A.length();i++)
        {
            hm.put(A.charAt(i),hm.getOrDefault(A.charAt(i),0)+1);
        }
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(int i = 0;i<A.length();i++)
        {
            hm2.put(B.charAt(i),hm2.getOrDefault(B.charAt(i),0)+1);
        }
        if(hm.equals(hm2))
            return true;
        for(int i = A.length();i<B.length();i++)
        {
            hm2.put(B.charAt(i),hm2.getOrDefault(B.charAt(i),0)+1);
            hm2.put(B.charAt(i-A.length()),hm2.get(B.charAt(i-A.length()))-1);
            if(hm2.get(B.charAt(i-A.length())) == 0)
                hm2.remove(B.charAt(i-A.length()));
            if(hm.equals(hm2))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String A = new String("ab");
        String B = new String("eidbaooo");
        System.out.println(checkInclusion(A, B));
    }
}
