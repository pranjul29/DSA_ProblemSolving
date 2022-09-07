/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34897/assignment/problems/46/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/evaluate-reverse-polish-notation/
An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each character may be an integer or an operator.

Problem Constraints
1 <= N <= 10^5

Example Input
Input 1:
    A =   ["2", "1", "+", "3", "*"]
Input 2:
    A = ["4", "13", "5", "/", "+"]

Example Output
Output 1:
    9
Output 2:
    6

Example Explanation
Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
*/
import java.util.*;
public class EvaluateExpression {
    public static int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0;i<A.length;i++)
        {
            try
            {
                stack.push(Integer.parseInt(A[i]));
            }
            catch (NumberFormatException e)
            {
                    int b = stack.pop();
                    int a = stack.pop();
                    if(A[i].equals("+"))
                    {
                        result = (a+b);
                        stack.push(result);
                    }
                    else if(A[i].equals("-"))
                    {
                        result = (a-b);
                        stack.push(result);
                    }
                    else if(A[i].equals("*"))
                    {
                        result = (a*b);
                        stack.push(result);
                    }
                    else if(A[i].equals("/"))
                    {
                        result = (a/b);
                        stack.push(result);
                    }
            }
        }
        result = stack.pop();
        return result;
    }
    public static void main(String[] args) {
        String[] A = {"2","1","+","3","*"};
        System.out.println(evalRPN(A));
    }
}
