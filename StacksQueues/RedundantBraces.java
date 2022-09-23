/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34897/homework/problems/274?navref=cl_tt_lst_nm
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
Check whether A has redundant braces or not.
NOTE: A will be always a valid expression and will not contain any white spaces.

Problem Constraints
1 <= |A| <= 10^5

Example Input
Input 1:
 A = "((a+b))"
Input 2:
 A = "(a+(a+b))"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 ((a+b)) has redundant braces so answer will be 1.
Explanation 2:
 (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
*/
import java.util.*;
public class RedundantBraces {
    public static int braces(String A) {
        char[] char_array = A.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Integer> precedence = new HashMap<>();
        precedence.put('^',2);
        precedence.put('/',1);
        precedence.put('*',1);
        precedence.put('+',0);
        precedence.put('-',0);
        for(int i = 0;i<char_array.length;i++)
        {
            if(precedence.containsKey(char_array[i]) || char_array[i] == '(' || char_array[i] == ')')
            {
                if(((i+2) < char_array.length) && char_array[i] == '(' && char_array[i+2] == ')')
                    return 1;
                if(char_array[i] == '(')
                    stack.push('(');
                else if(char_array[i] == ')')
                {
                    while(stack.peek() != '(')
                    {
                        stack.pop();
                    }
                    stack.pop();
                    if(!stack.empty() && (i!= (char_array.length-1)) && stack.peek() == '(' && char_array[i+1] == ')')
                        return 1;
                }
                else
                {
                    while(!stack.empty() && stack.peek()!= '(' && (precedence.get(stack.peek()) >= precedence.get(char_array[i])))
                    {
                        stack.pop();
                    }
                    stack.push(char_array[i]);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String A = new String("((a+b))");
        System.out.println(braces(A));
    }
}
