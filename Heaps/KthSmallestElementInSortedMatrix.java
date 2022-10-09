/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34945/homework/problems/4950/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
Given a sorted matrix of integers A of size N x M and an integer B.
Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.
NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.

Problem Constraints
1 <= N, M <= 500
1 <= A[i] <= 10^9
1 <= B <= N * M

Example Input
Input 1:
 A = [ [9, 11, 15],
       [10, 15, 17] ] 
 B = 6
Input 2:
 A = [  [5, 9, 11],
        [9, 11, 13],
        [10, 12, 15],
        [13, 14, 16],
        [16, 20, 21] ]
 B = 12

Example Output
Output 1:
 17
Output 2:
 16

Example Explanation
Explanation 1:
 6th smallest element in the sorted matrix is 17.
Explanation 2:
 12th smallest element in the sorted matrix is 16.
*/
import java.util.*;
public class KthSmallestElementInSortedMatrix {
    public static int solve(int[][] A, int B) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0;i<A.length;i++)
        {
            for(int j = 0;j<A[0].length;j++)
            {
                if(heap.size()<B)
                {
                    heap.add(A[i][j]);
                }
                else if(heap.size() == B && heap.peek() > A[i][j])
                {
                    int temp = heap.poll();
                    heap.add(A[i][j]);
                }
                else
                {
                    break;
                }
            }
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        int[][] A = {{5, 9, 11}, {9, 11, 13}, {10, 12, 15}, {13, 14, 16}, {16, 20, 21}};
        int B = 12;
        System.out.println(solve(A,B));
    }
}
