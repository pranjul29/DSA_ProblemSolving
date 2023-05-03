/* 
Source: https://leetcode.com/problems/removing-stars-from-a-string/description/
You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.
 
Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
Example 2:

Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters and stars *.
The operation above can be performed on s.
*/
import java.util.*;
public class RemovingStarsFromAString {
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] char_array = s.toCharArray();
        for(int i = 0;i<s.length();i++)
        {
            if(char_array[i] == '*')
            {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(char_array[i]);
        }
        StringBuilder str = new StringBuilder("");
        while(!stack.isEmpty())
            str.append(stack.pop());
        return str.reverse().toString();
    }
    public static void main(String[] args) {
        String s = new String("leet**cod*e");
        System.out.println(removeStars(s));
    }
}
