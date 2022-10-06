/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34945/assignment/problems/1243/?navref=cl_pb_nv_tb

Given an integer array A of size N.
You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.

Problem Constraints
1 <= N <= 105
0 <= A[i] <= 103

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [10, 2, 13, 4]

Example Output
Output 1:
 [-1, -1, 6, 24, 60]
Output 2:
 [-1, -1, 260, 520]

Example Explanation
Explanation 1:
 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60
 So, the output is [-1, -1, 6, 24, 60].
Explanation 2:
 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520
 So, the output is [-1, -1, 260, 520].

*/
import java.util.*;
public class ProductOfThree {
    public static int[] solve(int[] A) {
        int n = A.length;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] B = new int[A.length];
        for(int i = 0;i<B.length;i++)
        {
            if(i == 0 || i == 1)
            {
                B[i] = -1;
                heap.add(A[i]);
            }
            else
            {
                heap.add(A[i]);
                int a = heap.poll();
                int b = heap.poll();
                int c = heap.poll();
                B[i] = a*b*c;
                heap.add(a);
                heap.add(b);
                heap.add(c);
            }
        }
        return B;
    }
    public static void main(String[] args) {
        int[] A = {10, 2, 13, 4};
        System.out.println(solve(A));
    }
}
