/* 
Soure: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
*/
import java.util.*;
public class RemoveAllAdjacentElementsInAString {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] char_array = s.toCharArray();
        for(int i = 0;i<char_array.length;i++)
        {
            if(!stack.isEmpty())
                if(stack.peek() == char_array[i])
                    stack.pop();
                else
                    stack.push(char_array[i]);
            else
                stack.push(char_array[i]);
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty())
            str.append(stack.pop());
        return str.reverse().toString();
    }
    public static void main(String[] args) {
        String S = new String("abccbad");
        System.out.println(removeDuplicates(S));
    }
}
