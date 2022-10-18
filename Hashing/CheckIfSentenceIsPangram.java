/*
Source: https://leetcode.com/problems/check-if-the-sentence-is-pangram/
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:
Input: sentence = "leetcode"
Output: false
 
Constraints:
1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
*/
import java.util.*;
public class CheckIfSentenceIsPangram {
    public static boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        char[] char_array = sentence.toCharArray();
        for(int i = 0;i<char_array.length;i++)
        {
            set.add(char_array[i]);
        }
        for(char i = 'a';i<='z';i++)
        {
            if(!set.contains(i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String sentence = new String("thequickbrownfoxjumpsoverthelazydog");
        System.out.println(checkIfPangram(sentence));
    }
}
