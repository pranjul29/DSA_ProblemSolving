/*
Source: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:
Input: matrix = [[-5]], k = 1
Output: -5

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-10^9 <= matrix[i][j] <= 10^9
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n^2
*/
public class KSmallestInSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int lowest = matrix[0][0];
        int N = matrix.length;
        int highest = matrix[N-1][N-1];
        while(lowest<=highest)
        {
            int mid = lowest + (highest-lowest)/2;
            System.out.println("Lowest: "+lowest+" Mid: "+mid+" Highest: "+highest);
            int count = lessThenMid(matrix,mid);
            System.out.println("Count: "+count);
            if(count >= k)
            {
                highest = mid-1;
            }
            else
            {
                lowest = mid+1;
            }
        }
        return lowest;
    }
    public static int lessThenMid(int[][] matrix,int mid)
    {
        int row = matrix.length-1;
        int column = 0;
        int count = 0;
        while(row>=0 && column < matrix.length)
        {
            if(matrix[row][column] <= mid)
            {
                count=count+row+1;
                column++;
            }
            else
            {
                row--;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[][] arr = {{1,5,9},{10,11,13},{12,13,15}};
        int K = 8;
        System.out.println(kthSmallest(arr, K));
    }
}
