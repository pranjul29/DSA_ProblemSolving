/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34901/assignment/problems/332?navref=cl_tt_nv
Source: https://www.interviewbit.com/problems/nearest-smaller-element/
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
More formally,
G[i] for an element A[i] = an element A[j] such that
j is maximum possible AND
j < i AND
A[j] < A[i]
Elements for which no smaller element exist, consider the next smaller element as -1.

Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9

Example Input
Input 1:
 A = [4, 5, 2, 10, 8]
Input 2:
 A = [3, 2, 1]

Example Output
Output 1:
 [-1, 4, -1, 2, 2]
Output 2:
 [-1, -1, -1]

Example Explanation
Explanation 1:
index 1: No element less than 4 in left of 4, G[1] = -1
index 2: A[1] is only element less than A[2], G[2] = A[1]
index 3: No element less than 2 in left of 2, G[3] = -1
index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
Explanation 2:
index 1: No element less than 3 in left of 3, G[1] = -1
index 2: No element less than 2 in left of 2, G[2] = -1
index 3: No element less than 1 in left of 1, G[3] = -1
*/
import java.util.*;
public class NearestSmallerElement {
    public static int[] prevSmaller(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        ans[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(A[0]);
        for(int i = 1; i < n; i++)
        {
            while(!stack.empty() && stack.peek()>=A[i])
                stack.pop();
            if(stack.empty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(A[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(prevSmaller(arr));
    }
}
