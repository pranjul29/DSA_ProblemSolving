/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34945/assignment/problems/4395/?navref=cl_pb_nv_tb

Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.

Problem Constraints
1 <= length of the array <= 5*10^5
1 <= B <= 5 * 10^6
-100 <= A[i] <= 100

Example Input
Input 1:
 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:
 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10

Example Output
Output 1:
 196
Output 2:
 362

Example Explanation
Explanation 1:
 Final array after B modifications = [24, 68, 29, -9, 84]
Explanation 2:
 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
*/
import java.util.*;
public class MaximumArraySumAfterBNegations {
    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int sum = 0;
        for(int i = 0;i<A.length;i++)
        {
            sum += A[i];
            heap.add(A[i]);
        }
        while(B!=0)
        {
            int temp = heap.poll();
            sum -= temp;
            temp = temp*(-1);
            heap.add(temp);
            sum += temp;
            B--;
        }
        return sum;
    }    
    public static void main(String[] args) {
        int[] A = {24, -68, -29, -9, 84};
        int B = 4;
        System.out.println(solve(A,B));
    }
}
