/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34901/assignment/problems/7042?navref=cl_tt_lst_nm
Given an array of integers A.
value of a array = max(array) - min(array).
Calculate and return the sum of values of all possible subarrays of A modulo 109+7.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000

Example Input
Input 1:
 A = [1]
Input 2:
 A = [4, 7, 3, 8]

Example Output
Output 1:
 0
Output 2:
 26

Example Explanation
Explanation 1:
Only 1 subarray exists. Its value is 0.
Explanation 2:
value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
*/
import java.util.*;
public class MaxMin {
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
    public static int[] prevGreater(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        ans[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < n; i++)
        {
            while(!stack.empty() && A[stack.peek()]<=A[i])
                stack.pop();
            if(stack.empty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    public static int[] nextGreater(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        ans[n-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for(int i = n-1; i >= 0; i--)
        {
            while(!stack.empty() && A[stack.peek()]<=A[i])
                stack.pop();
            if(stack.empty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    public static int solve(int[] A) {
        int M = 1000000007;
        int[] prevSmaller = prevSmaller(A);
        int[] nextSmaller = nextSmaller(A);
        int[] prevGreater = prevGreater(A);
        int[] nextGreater = nextGreater(A);
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
            

            int left_large = prevGreater[i] + 1;
            if(prevGreater[i] == -1)
            {
                left_large = 0;
            }
            int right_large = nextGreater[i] - 1;
            if(nextGreater[i] == -1)
            {
                right_large = A.length-1;
            }
            long total_subarray_large = ((long)(i-left_large+1))*((long)(right_large-i+1));
            total = (total + (total_subarray_large*((long)A[i]))%M)%M;
            total = (total - (total_subarray_small*((long)A[i]))%M)%M;
            if(total < 0)
                total += M;
        }
        return (int)total;
    }
    
    public static void main(String[] args) {
        int[] arr = {4,7,3,8};
        System.out.println(solve(arr));
    }    
}
