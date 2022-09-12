/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34905/homework/problems/4364/?navref=cl_pb_nv_tb
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
NOTE: All the A integers will fit in 32-bit integers.

Problem Constraints
1 <= A <= 29500

Example Input
Input 1:
 A = 3
Input 2:
 A = 7

Example Output
Output 1:
 [1, 2, 3]
Output 2:
 [1, 2, 3, 11, 12, 13, 21]

Example Explanation
Explanation 1:
 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:
 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
*/
import java.util.*;
public class NIntegers {
    public static int[] solve(int A) {
        int count = 3;
        int deleted = 0;
        Queue<StringBuilder> queue = new LinkedList<StringBuilder>();
        queue.add(new StringBuilder("1"));
        queue.add(new StringBuilder("2"));
        queue.add(new StringBuilder("3"));
        int[] result = new int[A];
        int counter = 0;
        while(count < A)
        {
            if(counter==A)
                break;
            StringBuilder S = queue.peek();
            queue.remove();
            result[counter] = Integer.parseInt(S.toString());
            counter++;
            if(counter==A)
                break;
            deleted++;
            queue.add(new StringBuilder(S+ "1"));
            queue.add(new StringBuilder(S+"2"));
            queue.add(new StringBuilder(S+"3"));
            count+=3;
        }
        while(deleted < A)
        {
            if(counter==A)
                break;
            StringBuilder S = queue.peek();
            result[counter] = Integer.parseInt(S.toString());
            queue.remove();
            deleted++;
            counter++;
            
        }
        return result;
    }
    public static void main(String[] args) {
        int A = 9;
        System.out.println(solve(A));
    }    
}
