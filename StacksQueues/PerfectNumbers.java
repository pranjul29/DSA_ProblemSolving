/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34905/assignment/problems/3297/?navref=cl_pb_nv_tb
Given an integer A, you have to find the Ath Perfect Number.
A Perfect Number has the following properties:
It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

Problem Constraints
1 <= A <= 100000

Example Input
Input 1:
 A = 2
Input 2:
 A = 3

Example Output
Output 1:
 22
Output 2:
 1111

Example Explanation
Explanation 1:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
Explanation 2:
First four perfect numbers are:
1. 11
2. 22
3. 1111
4. 1221
*/
import java.util.*;
public class PerfectNumbers {
    public static String solve(int A) {
        int count = 2;
        int deleted = 0;
        Queue<StringBuilder> queue = new LinkedList<StringBuilder>();
        queue.add(new StringBuilder("1"));
        queue.add(new StringBuilder("2"));
        while(count < A)
        {
            StringBuilder S = queue.peek();
            queue.remove();
            deleted++;
            queue.add(new StringBuilder(S+ "1"));
            queue.add(new StringBuilder(S+"2"));
            count+=2;
        }
        while(deleted < A-1)
        {
            StringBuilder S = queue.peek();
            queue.remove();
            deleted++;
        }
        StringBuilder result = new StringBuilder(queue.peek());
        result.append(queue.peek().reverse());
        return result.toString();
    } 
    public static void main(String[] args) {
        int A = 1239;
        System.out.println(solve(A));
    }   
}
