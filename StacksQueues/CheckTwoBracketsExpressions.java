/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34897/homework/problems/4218/?navref=cl_pb_nv_tb
Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.

Problem Constraints
1 <= length of the each String <= 100

Input Format
The given arguments are string A and string B.
Output Format
Return 1 if they represent the same expression else return 0.

Example Input
Input 1:
 A = "-(a+b+c)"
 B = "-a-b-c"
Input 2:
 A = "a-b-(c-d)"
 B = "a-b-c-d"

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B. 
Explanation 2:
 Both the expression are different.
*/
import java.util.*;
public class CheckTwoBracketsExpressions {
    static int[] char_array = new int[26];
    static boolean adjSign(String A,int i)
    {
        if(i == 0)
            return true;
        if(A.charAt(i-1) == '-')
            return false;
        return true;
    }
    public static void eval(String A, boolean add)
    {
        Stack<Boolean> stk = new Stack<>();
        stk.push(true);
        for(int i = 0;i<A.length();i++)
        {
            // System.out.println(stk);
            if(A.charAt(i) == '+' || A.charAt(i) == '-')
                continue;
            if(A.charAt(i) == '(')
            {
                if(adjSign(A,i))
                    stk.push(stk.peek());
                else
                    stk.push(!stk.peek());
            }
            else if(A.charAt(i) == ')')
                stk.pop();
            else
            {
                if(stk.peek())
                    char_array[A.charAt(i) - 'a'] += adjSign(A,i) ? (add ? 1 : -1) : (add ? -1 : 1);
                else
                    char_array[A.charAt(i) - 'a'] += adjSign(A,i) ? (add ? -1 : 1) : (add ? 1 : -1);
            }
        }
    }
    public static int solve(String A, String B) {
        eval(A,true);
        for(int i = 0;i<26;i++)
            System.out.print(char_array[i] + " ");
        System.out.println();
        eval(B,false);
        for(int i = 0;i<26;i++)
            System.out.print(char_array[i] + " ");
        System.out.println();
        for(int i = 0;i<26;i++)
            if(char_array[i] != 0)
                return 0;
        return 1;
    }
    public static void main(String[] args) {
        String A = new String("-(a+b)-(z)+(p-q+r)-(e+f)");
        String B = new String("-e+f-(-p+q-r)+(-a-b)-z");
        System.out.println(solve(A,B));
    }
}
