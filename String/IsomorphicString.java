/*
Source: https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan&id=level-1
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 
Constraints:

1 <= s.length <= 5 * 10^4
t.length == s.length
s and t consist of any valid ascii character.
*/
import java.util.*;
public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++)
        {
            char c = s.charAt(i);
            char c_t = t.charAt(i);
            if(!map.containsKey(c))
            {
                if(set.contains(c_t))
                    return false;
                map.put(c,c_t);
                set.add(c_t);
            }
            else
            {
                if(map.get(c) != c_t)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = new String("paper");
        String t = new String("title");
        System.out.println(isIsomorphic(s,t));
    }
}
