/*
Source: https://leetcode.com/problems/maximal-rectangle/
Source: https://www.scaler.com/academy/mentee-dashboard/class/34901/homework/problems/4349/?navref=cl_pb_nv_tb
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:
Input: matrix = [["0"]]
Output: 0
Example 3:
Input: matrix = [["1"]]
Output: 1
 
Constraints:
rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'
*/
import java.util.*;
public class MaximalRectangle {
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
    public static int maximalRectangle(char[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[] arr = new int[M];
        int max_area = 0;
        int area = 0;
        for(int i = 0;i<N;i++)
        {
            for(int j = 0;j<M;j++)
            {
                if(matrix[i][j] == '0')
                {
                    arr[j] = 0;
                }
                else
                {
                    arr[j]++;
                }
            }
            area = largestRectangleArea(arr);
            max_area = Math.max(max_area,area);
        }
        return max_area;
    }
    public static void main(String[] args) {
        char[][] matrix = {{"1","0","1","0","0"},{"1","0","1","1","1"},{"1","1","1","1","1"},{"1","0","0","1","0"}};
        System.out.println(maximalRectangle(matrix));
    }    
}
