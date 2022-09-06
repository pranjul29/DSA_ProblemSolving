/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34897/assignment/problems/968/?navref=cl_pb_nv_tb
You are given a string A.
An operation on the string is defined as follows:
Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "acd".
Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.

Problem Constraints
1 <= |A| <= 100000

Example Input
Input 1:
 A = abccbc
Input 2:
 A = ab

Example Output
Output 1:
 "ac"
Output 2:
 "ab"

Example Explanation
Explanation 1:
Remove the first occurrence of same consecutive characters. eg for a string "abbc", 
the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "ac".
Explanation 2:
 No removals are to be done.
*/
import java.util.*;
public class DoubleCharacterTrouble {
    public static String solve(String A) {
        char[] char_array = A.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<char_array.length;i++)
        {
            if(!stack.empty() && stack.peek() == char_array[i])
            {
                stack.pop();
            }
            else
            {
                stack.push(char_array[i]);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.empty())
        {
            str.append(stack.pop());
        }
        StringBuilder reverseStr = str.reverse();
        return reverseStr.toString();
    }
    public static void main(String[] args) {
        String A = new String("acbbbca");
        System.out.println(solve(A));
    }
}
