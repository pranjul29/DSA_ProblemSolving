/*
Source: https://leetcode.com/problems/ransom-note/

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
 
Constraints:
1 <= ransomNote.length, magazine.length <= 10^5
ransomNote and magazine consist of lowercase English letters.
*/
import java.util.*;
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hm = new HashMap<>();
        char[] magazine_array = magazine.toCharArray();
        for(int i = 0;i<magazine_array.length;i++)
        {
            hm.put(magazine_array[i],hm.getOrDefault(magazine_array[i],0)+1);
        }
        for(int i = 0;i<ransomNote.length();i++)
        {
            char c = ransomNote.charAt(i);
            if(hm.containsKey(c))
            {
                int count = hm.get(c);
                count--;
                if(count == 0)
                {
                    hm.remove(c);
                }
                else
                {
                    hm.put(c,count);
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String ransomNote = new String("aa");
        String magazine = new String("aab");
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
