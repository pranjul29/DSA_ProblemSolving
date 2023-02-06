/* 
 Source; https://leetcode.com/problems/spiral-matrix/description/
 Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/
import java.util.*;
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int first_row = 0;
        int last_row = n-1;
        int first_column = 0;
        int last_column = m-1;
        int direction = 1;
        List<Integer> result = new ArrayList<Integer>();
        while(first_row <= last_row && first_column <= last_column)
        {
            switch(direction)
            {
                case 1:
                    for(int i = first_column;i<=last_column;i++)
                        result.add(matrix[first_row][i]);
                    first_row++;
                    direction = 2;
                    break;
                
                case 2:
                    for(int i = first_row;i<=last_row;i++)
                        result.add(matrix[i][last_column]);
                    last_column--;
                    direction = 3;
                    break;
                
                case 3:
                    for(int i = last_column;i>=first_column;i--)
                        result.add(matrix[last_row][i]);
                    last_row--;
                    direction = 4;
                    break;
                
                case 4:
                    for(int i = last_row;i>=first_row;i--)
                        result.add(matrix[i][first_column]);
                    first_column++;
                    direction = 1;
                    break;
            }
            // System.out.println(result);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
}
