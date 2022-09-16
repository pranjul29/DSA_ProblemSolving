/*
Source: https://leetcode.com/problems/sum-of-subarray-minimums/
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

Example 1:
Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:
Input: arr = [11,81,94,43,3]
Output: 444
 
Constraints:
1 <= arr.length <= 3 * 10^4
1 <= arr[i] <= 3 * 10^4
*/
import java.util.*;
public class SumOfSubarrayMinimums {
    public static int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        ans[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < n; i++)
        {
            while(!stack.empty() && A[stack.peek()]>A[i])
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
    public static int sumSubarrayMins(int[] A) {
        int M = 1000000007;
        int[] prevSmaller = prevSmaller(A);
        int[] nextSmaller = nextSmaller(A);
        for(int i = 0;i<prevSmaller.length;i++)
        {
            System.out.print(prevSmaller[i]+" ");
        }
        System.out.println();
        for(int i = 0;i<nextSmaller.length;i++)
        {
            System.out.print(nextSmaller[i]+" ");
        }
        System.out.println();
        long total = 0;
        for(int i = 0;i<A.length;i++)
        {
            int left_small = prevSmaller[i] + 1;
            if(prevSmaller[i] == -1)
            {
                left_small = 0;
            }
            int right_small = nextSmaller[i] - 1;
            if(nextSmaller[i] == -1)
            {
                right_small = A.length-1;
            }
            long total_subarray_small = ((long)(i-left_small+1))*((long)(right_small-i+1));
            total = (total + (total_subarray_small*((long)A[i]))%M)%M;
            System.out.println(total);
        }
        return (int)total;
    }
}
