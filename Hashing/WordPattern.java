/* 
Source: https://leetcode.com/problems/word-pattern/description/
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 
Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
*/
import java.util.*;
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;
        HashMap<Character,String> word_pattern_map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<pattern.length();i++)
        {
            // System.out.println(word_pattern_map);
            char c = pattern.charAt(i);
            
            if(word_pattern_map.containsKey(c))
            {
                // System.out.println(word_pattern_map.get(c));
                // System.out.println(words[i]);
                if(!word_pattern_map.get(c).equals(words[i]))
                    return false;
            }
            else
            {
                if(set.contains(words[i]))
                    return false;
                word_pattern_map.put(c,words[i]);
                set.add(words[i]);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = new String("dog cat cat dog");
        String pattern = new String("abba");
        System.out.println(wordPattern(pattern,s));
    }
}
