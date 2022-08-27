/*
Source: https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
It is guaranteed that there will be a rectangle with a sum no larger than k.

Example 1:
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
Example 2:
Input: matrix = [[2,2,-1]], k = 3
Output: 3
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-10^5 <= k <= 10^5
*/
public class MaxSumOfRectangeNoLargerThanK {
    public static int maxSumSubmatrix(int[][] matrix, int K) {
        int N = matrix.length;
        int M = matrix[0].length;
        for(int i = 1;i<M;i++)
        {
            for(int j = 0;j<N;j++)
            {
                matrix[j][i] = matrix[j][i-1] + matrix[j][i];
            }
        }
        for(int i = 1;i<N;i++)
        {
            for(int j = 0;j<M;j++)
            {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j];
            }
        }
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0;i<N;i++)
        {
            for(int j = 0;j<M;j++)
            {
                for(int k = i;k<N;k++)
                {
                    for(int l = j;l<M;l++)
                    {
                        int sum = matrix[k][l];
                        if(i != 0)
                            sum -= matrix[i-1][l];
                        if(j != 0)
                            sum -= matrix[k][j-1];
                        if(i!=0 && j!=0)
                            sum += matrix[i-1][j-1];
                        if(sum <= K)
                        {
                            max_sum = Math.max(max_sum,sum);
                        }
                    }
                }
            }
        }
        return max_sum;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{0,-2,3}};
        int K = 2;
        System.out.println(maxSumSubmatrix(matrix, K));
    }
}
