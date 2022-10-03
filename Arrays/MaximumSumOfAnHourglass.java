/*
Source: https://leetcode.com/problems/maximum-sum-of-an-hourglass/
You are given an m x n integer matrix grid.
We define an hourglass as a part of the matrix with the following form:

Return the maximum sum of the elements of an hourglass.
Note that an hourglass cannot be rotated and must be entirely contained within the matrix.

Example 1:
Input: grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
Output: 30
Explanation: The cells shown above represent the hourglass with the maximum sum: 6 + 2 + 1 + 2 + 9 + 2 + 8 = 30.
Example 2:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 35
Explanation: There is only one hourglass in the matrix, with the sum: 1 + 2 + 3 + 5 + 7 + 8 + 9 = 35.
 
Constraints:

m == grid.length
n == grid[i].length
3 <= m, n <= 150
0 <= grid[i][j] <= 10^6
*/
public class MaximumSumOfAnHourglass {
    public static int maxSum(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0;i<N-2;i++)
        {
            for(int j = 0;j<M-2;j++)
            {
                int sum = 0;
                // ArrayList<Integer> temp = new ArrayList<Integer>();
                for(int k = j;k<=j+2;k++)
                {
                    sum += grid[i][k];
                    // temp.add(grid[i][k]);
                }
                sum+=grid[i+1][j+1];
                // temp.add(grid[i+1][j+1]);
                for(int k = j;k<=j+2;k++)
                {
                    sum += grid[i+2][k];
                    // temp.add(grid[i+2][k]);
                }
                max_sum = Math.max(max_sum,sum);
                // System.out.println(temp);
                // System.out.println(max_sum);
            }
        }
        return max_sum;
    }
    public static void main(String[] args) {
        int[][] grid = {{6,2,1,3},{4,2,1,5},{9,2,8,7},{4,1,2,9}};
        System.out.println(maxSum(grid));
    }
}
