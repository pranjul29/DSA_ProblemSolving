/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34897/homework/problems/4353/?navref=cl_pb_nv_tb
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
Find and return the postfix expression of A.

NOTE:
^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.

Problem Constraints
1 <= length of the string <= 500000

Example Input
Input 1:
 A = "x^y/(a*z)+b"
Input 2:
 A = "a+b*(c^d-e)^(f+g*h)-i"
Example Output
Output 1:
 "xy^az* /b+"
 Output 2:
 "abcd^e-fgh*+^*+i-"

Example Explanation
Explanation 1:
 Ouput dentotes the postfix expression of the given input.
*/
import java.util.*;
public class InfixToPostfix {
    public static String solve(String A) {
        char[] char_array = A.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Integer> precedence = new HashMap<>();
        precedence.put('^',2);
        precedence.put('/',1);
        precedence.put('*',1);
        precedence.put('+',0);
        precedence.put('-',0);
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<char_array.length;i++)
        {
            System.out.println("CHAR: "+char_array[i]);
            if(precedence.containsKey(char_array[i]) || char_array[i] == '(' || char_array[i] == ')')
            {
                if(char_array[i] == '(')
                    stack.push('(');
                else if(char_array[i] == ')')
                {
                    while(stack.peek() != '(')
                    {
                        result.append(stack.pop());
                    }
                    stack.pop();
                }
                else
                {
                    while(!stack.empty() && stack.peek()!= '(' && (precedence.get(stack.peek()) >= precedence.get(char_array[i])))
                    {
                        System.out.println(precedence.getOrDefault(stack.peek(),-1));
                        System.out.println(precedence.getOrDefault(char_array[i],-1));
                        result.append(stack.pop());
                    }
                    stack.push(char_array[i]);
                }
            }
            else
            {
                result.append(char_array[i]);
            }
            System.out.println(result);
            System.out.println(stack);
        }
        while(!stack.empty())
            result.append(stack.pop());
        return result.toString();
    }
    public static void main(String[] args) {
        String A = new String("a*(r+o*h)");
        System.out.println(solve(A));
    }
}
