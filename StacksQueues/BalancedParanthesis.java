/*
Source: https://leetcode.com/problems/valid-parentheses/
Source: https://www.scaler.com/academy/mentee-dashboard/class/34897/assignment/problems/678/?navref=cl_pb_nv_tb

Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100

Example Input
Input 1:
 A = {([])}
Input 2:
 A = (){
Input 3:
 A = ()[] 

Example Output
Output 1:
 1 
Output 2:
 0 
Output 3:
 1 

Example Explanation
You can clearly see that the first and third case contain valid paranthesis.
In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
*/
import java.util.*;
public class BalancedParanthesis {
    public static int solve(String A) {
        char[] A_array = A.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<A_array.length;i++)
        {
            if(A_array[i] == '(' || A_array[i] == '{' || A_array[i] == '[')
                stack.push(A_array[i]);
            else if(A_array[i] == ')')
            {
                if(stack.empty())
                    return 0;
                else if(stack.peek() != '(')
                {
                    return 0;
                }
                else
                {
                    stack.pop();
                }
            }
            else if(A_array[i] == '}')
            {
                if(stack.empty())
                    return 0;
                else if(stack.peek() != '{')
                {
                    return 0;
                }
                else
                {
                    stack.pop();
                }
            }
            else if(A_array[i] == ']')
            {
                if(stack.empty())
                    return 0;
                else if(stack.peek() != '[')
                {
                    return 0;
                }
                else
                {
                    stack.pop();
                }
            }
            else
                return 0;
        }
        if(stack.empty())
            return 1;
        else
            return 0;
    }
    public static void main(String[] args) {
        String S = new String("{[]}");
        System.out.println(solve(S));
    }
}
