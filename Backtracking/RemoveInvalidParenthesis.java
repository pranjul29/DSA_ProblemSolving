/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34957/homework/problems/4818/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/remove-invalid-parentheses/description/
Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.

Return all possible results.

You can return the results in any order.

Problem Constraints
1 <= length of the string <= 20

Input Format
The only argument given is string A.

Output Format
Return all possible strings after removing the minimum number of invalid parentheses.

Example Input
Input 1:
 A = "()())()"
Input 2:
 A = "(a)())()"

Example Output
Output 1:
 ["()()()", "(())()"]
Output 2:
 ["(a)()()", "(a())()"]

Example Explanation
Explanation 1:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 4 then string becomes : "()()()"
        2. Remove the parentheses at index 2 then string becomes : "(())()"
Explanation 2:

 By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 5 then string becomes : "(a)()()"
        2. Remove the parentheses at index 2 then string becomes : "(a())()"
*/
import java.util.*;
public class RemoveInvalidParenthesis {
    static HashSet<String> validStrings;
    static int longest = 0;
    public static boolean isValid(String A) {
        char[] A_array = A.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<A_array.length;i++)
        {
            if(A_array[i] == '(')
                stack.push(A_array[i]);
            else if(A_array[i] == ')')
            {
                if(stack.empty())
                    return false;
                else if(stack.peek() != '(')
                {
                    return false;
                }
                else
                {
                    stack.pop();
                }
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
    public static void generate(String A, int N, int pos,ArrayList<Character> temp)
    {
        if(N == pos)
        {
            StringBuilder curr_string = new StringBuilder(temp.size());
            for(Character ch: temp)
            {
                curr_string.append(ch);
            }
            if(temp.size() >= longest)
            {
                if(isValid(curr_string.toString()))
                {
                    longest = temp.size();
                    validStrings.add(curr_string.toString());
                }
            }
            return;
        }
        generate(A,N,pos+1,temp);
        temp.add(A.charAt(pos));
        generate(A,N,pos+1,temp);
        temp.remove(temp.size()-1);
    }
    public static ArrayList<String> solve(String A) {
        validStrings = new HashSet<>();
        ArrayList<Character> temp = new ArrayList<>();
        generate(A,A.length(),0,temp);
        ArrayList<String> result = new ArrayList<>();
        System.out.println(validStrings);
        for (String str : validStrings)
        {
            if(longest == str.length())
            {
                result.add(str);
            }
        }
        if(result.size() == 0)
            result.add(new String(""));
        return result;
    }
    public static void main(String[] args) {
        String A = new String(")(()((((()((");
        System.out.println(solve(A));
    }
}
