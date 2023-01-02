/* 
Source: https://leetcode.com/problems/detect-capital/description/
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 
Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
*/
public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        if(Character.isUpperCase(word.charAt(0)))
        {
            boolean allLower = true;
            boolean allUpper = true;
            for(int i = 1;i<word.length();i++)
            {
                if(Character.isUpperCase(word.charAt(i)))
                {
                    allLower = false;
                }
                if(Character.isLowerCase(word.charAt(i)))
                {
                    allUpper = false;
                }
            }
            return allUpper | allLower;
        }
        else
        {
            for(int i = 1;i<word.length();i++)
                if(Character.isUpperCase(word.charAt(i)))
                    return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String word = "USA";
        System.out.println(detectCapitalUse(word));
    }
}
