/*
Source: https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4

*/

public class MatrixSearch{
    public static boolean searchMatrix(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;
        int low = 0;
        int high = N-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(A[mid][M-1] == B)
                return true;
            else if(A[mid][M-1]<B)
                low = mid+1;
            else
                high = mid-1;
        }
        int row = 0;
        if((low < N) && A[low][M-1] > B)
            row = low;
        else if((high < N) && A[high][M-1] > B)
            row = high;
        low = 0;
        high = M-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(A[row][mid] == B)
                return true;
            else if(A[row][mid] < B)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;  
    }
    public static void main(String[] args)
    {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(searchMatrix(arr, target));
    }
}