/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34901/assignment/problems/49/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/largest-rectangle-in-histogram/
Given an array of integers A.
A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000000

Example Input
Input 1:
 A = [2, 1, 5, 6, 2, 3]
Input 2:
 A = [2]

Example Output
Output 1:
 10
Output 2:
 2

Example Explanation
Explanation 1:
The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:
Largest rectangle has area 2.
*/
import java.util.*;
public class LargestRectangleHistogram {
    public static int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        ans[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < n; i++)
        {
            while(!stack.empty() && A[stack.peek()]>=A[i])
                stack.pop();
            if(stack.empty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    public static int[] nextSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        ans[n-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for(int i = n-1; i >= 0; i--)
        {
            while(!stack.empty() && A[stack.peek()]>=A[i])
                stack.pop();
            if(stack.empty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    public static int largestRectangleArea(int[] A) {
        int[] nsl = prevSmaller(A);
        int[] nsr = nextSmaller(A);
        long max_area = 0;
        for(int i = 0;i<A.length;i++)
        {
            long px;
            long py;
            if(nsl[i] != -1)
                px = (long)(nsl[i]+1);
            else
                px = 0;
            if(nsr[i] == -1)
                py = A.length-1;
            else
                py = (long)(nsr[i]-1);
            long width = py-px+1;
            long area = width*((long)(A[i]));
            if(area > max_area)
                max_area = area;
        }
        return (int)max_area;
    }
    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(A));
    }
}
