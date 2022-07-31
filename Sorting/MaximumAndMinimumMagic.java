/*

Source: https://www.scaler.com/academy/mentee-dashboard/class/29502/homework/problems/8644/?navref=cl_pb_nv_tb

 * Problem Description:
 Given an array of integers A of size N where N is even.
 
 Divide the array into two subsets such that
 1.Length of both subset is equal.
 2.Each element of A occurs in exactly one of these subset.

 Magic number = sum of absolute difference of corresponding elements of subset.
 
 Note: You can reorder the position of elements within the subset to find the value of the magic number.
 
 For Ex:- 
    subset 1 = {1, 5, 1}, 
    subset 2 = {1, 7, 11}
    Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12

 Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.
 Problem Constraints
    1 <= N <= 10^5
    -10^9 <= A[i] <= 10^9
    N is even

 Example Input
    Input 1:
    A = [3, 11, -1, 5]
    
    Input 2:
    A = [2, 2]

 Example Output
    Output 1:
    [14, 10]
    
    Output 2:
    [0, 0]
 */
import java.util.*;
public class MaximumAndMinimumMagic {
    public static int[] solve(int[] A) {
        int M = 1000000007;
        Arrays.sort(A);
        long maximum = 0;
        for(int i = 0;i<A.length/2;i++)
        {
            maximum = (maximum + Math.abs(A[i]-A[A.length-i-1]))%M;
        }
        long minimum = 0;
        for(int i = 0;i<A.length;i=i+2)
        {
            minimum = (minimum + Math.abs(A[i+1]-A[i]))%M;
        }
        int[] result = {(int)maximum,(int)minimum};
        return result;
    }
    public static void main(String[] args)
    {
        int[] arr = {3, 11, -1, 5};
        int[] result = solve(arr);
        for(int i = 0;i<result.length;i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}
