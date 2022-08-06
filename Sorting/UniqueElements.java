/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29500/homework/problems/1224/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/minimum-increment-to-make-array-unique/
Description: You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.

Find the minimum number of steps.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9

Example Input
Input 1:
 A = [1, 1, 3]
Input 2:
 A = [2, 4, 5]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
Explanation 2:
 All elements are distinct.

*/
import java.util.*;
public class UniqueElements {
    public static int solve(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for(int i =1;i<A.length;i++)
        {
            if(A[i]<=A[i-1])
            {
                count = count + A[i-1]-A[i]+1;
                A[i] = A[i-1]+1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 5};
        System.out.println(solve(arr));
    }
}
