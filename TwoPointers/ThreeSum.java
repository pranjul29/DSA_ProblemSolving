/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/homework/problems/165/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/3sum-closest/

Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
Assume that there will only be one solution.

Problem Constraints
-10^8 <= B <= 10^8
1 <= N <= 10^4
-10^8 <= A[i] <= 10^8

Example Input
Input 1:
A = [-1, 2, 1, -4]
B = 1
Input 2:
A = [1, 2, 3]
B = 6

Example Output
Output 1:
2
Output 2:
6

Example Explanation
Explanation 1:
 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:
 Take all elements to get exactly 6.
*/
import java.util.*;
public class ThreeSum {
    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int first = -1;
        int second = -1;
        int third = -1;
        long minimum_diff = Integer.MAX_VALUE;
        for(int k = 0;k<A.length;k++)
        {
            long target = 1l*B - 1l*A[k];
            int i = k+1;
            int j = A.length-1;
            while(i<j)
            {
                long sum = 1l*A[i] + 1l*A[j];
                if(sum == target)
                {
                    minimum_diff = 0;
                    first = A[i];
                    second = A[j];
                    third = A[k];
                    break;
                }
                else if(sum < target)
                {
                    if(minimum_diff > Math.abs(sum-target))
                    {
                        minimum_diff = Math.abs(sum-target);
                        first = A[i];
                        second = A[j];
                        third = A[k];
                    }
                    i++;
                }
                else
                {
                    if(minimum_diff > Math.abs(sum-target))
                    {
                        minimum_diff = Math.abs(sum-target);
                        first = A[i];
                        second = A[j];
                        third = A[k];
                    }
                    j--;
                }
            }
        }
        return first+second+third;
    }
    public static void main(String[] args) {
        // int[] arr = {-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3};
        int[] arr = {5, -2, -1, -10, 10};
        int B = 5;
        System.out.println(threeSumClosest(arr, B));
    }
}
