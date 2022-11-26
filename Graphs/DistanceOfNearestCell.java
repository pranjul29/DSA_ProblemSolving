/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34997/homework/problems/4705/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/01-matrix/
Given a matrix of integers A of size N x M consisting of 0 or 1.
For each cell of the matrix find the distance of nearest 1 in the matrix.
Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.
NOTE: There is atleast one 1 is present in the matrix.

Problem Constraints
1 <= N, M <= 1000
0 <= A[i][j] <= 1

Input Format
The first argument given is the integer matrix A.

Output Format
Return the matrix B.

Example Input
Input 1:
 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1] 
       [0, 1, 1, 0]
     ]
Input 2:
 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]  
     ]
Example Output
Output 1:
 [ 
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]   
 ]
Output 2:
 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4] 
 ]

Example Explanation
Explanation 1:
 A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 A[1][0], A[1][1] will be nearest to A[1][2].
 A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
Explanation 2:
 There is only a single 1. Fill the distance from that 1.
*/
import java.util.*;
class Pair{
    int x;
    int y;
    public Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class DistanceOfNearestCell {
    static boolean isValid(int x,int y,int N,int M)
    {
        if(x < 0 || y < 0 || x >= N || y >= M) 
            return false;
        return true;
    }
    public static int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] result = new int[N][M];
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0;i<N;i++)
        {
            for(int j = 0;j<M;j++)
            {
                if(A[i][j] == 1)
                {
                    queue.add(new Pair(i,j));
                }
            }
        }
        int[] x_n = {1,-1,0,0};
        int[] y_n = {0,0,-1,1};
        while(!queue.isEmpty())
        {
            Pair curr = queue.peek();
            queue.remove();
            for(int i = 0;i<4;i++)
            {
                int x = curr.x + x_n[i];
                int y = curr.y + y_n[i];
                if(isValid(x,y,N,M) && A[x][y]!=1)
                {
                    A[x][y] = 1;
                    result[x][y] = result[curr.x][curr.y] + 1;
                    queue.add(new Pair(x,y));
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] A = {{0, 0, 0, 1},{0, 0, 1, 1},{0, 1, 1, 0}};
        System.out.println(solve(A));
    }
}
