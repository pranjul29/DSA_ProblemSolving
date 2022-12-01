/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34997/homework/problems/418/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/valid-path/
There is a rectangle with left bottom as (0, 0) and right up as (x, y).
There are N circles such that their centers are inside the rectangle.
Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.

Problem Constraints
0 <= x , y, R <= 100
1 <= N <= 1000
Center of each circle would lie within the grid

Input Format
1st argument given is an Integer x , denoted by A in input.
2nd argument given is an Integer y, denoted by B in input.
3rd argument given is an Integer N, number of circles, denoted by C in input.
4th argument given is an Integer R, radius of each circle, denoted by D in input.
5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle

Output Format
Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).

Example Input
Input 1:
 x = 2
 y = 3
 N = 1
 R = 1
 A = [2]
 B = [3]
Input 2:
 x = 1
 y = 1
 N = 1
 R = 1
 A = [1]
 B = [1]

Example Output
Output 1:
 NO
Output 2:
 NO

Example Explanation
Explanation 1:
 There is NO valid path in this case
Explanation 2:
 There is NO valid path in this case
*/
import java.util.*;
public class ValidPath {
    static int[][] matrix;
    static int[][] visited;
    static boolean isValid(int x,int y,int N,int M)
    {
        if(x < 0 || y < 0 || x >= N || y >= M)
            return false;
        return true;
    }
    static void dfs(int x,int y,int A,int B)
    {
        visited[x][y] = 1;
        int[] x_n = {0,0,1,-1,1,-1,-1,1};
        int[] y_n = {1,-1,0,0,1,-1,1,-1};
        for(int i = 0;i<8;i++)
        {
            int curr_x = x + x_n[i];
            int curr_y = y + y_n[i];
            if(isValid(curr_x,curr_y,A,B) && visited[curr_x][curr_y] == 0 && matrix[curr_x][curr_y]==1)
            {
                dfs(curr_x,curr_y,A,B);
            }
        }
    }
    public static String solve(int A, int B, int C, int D, int[] E, int[] F) {
        matrix = new int[A+1][B+1];
        visited = new int[A+1][B+1];
        for(int i = 0;i<=A;i++)
        {
            for(int j = 0;j<=B;j++)
            {
                int value = 1;
                for(int k = 0;k<C;k++)
                {
                    int distance = (int)(E[k]-i)*(E[k]-i) + (int)(F[k]-j)*(F[k]-j);
                    if(distance <= D*D)
                    {
                        value = 0;
                        break;
                    }
                }
                matrix[i][j] = value;
            }
        }
        if(matrix[0][0] == 0 || matrix[A][B] == 0)
            return new String("NO");
        dfs(0,0,A+1,B+1);
        if(visited[A][B] == 1)
            return new String("YES");
        return new String("NO");
    }
    public static void main(String[] args) {
        int x = 47;
        int y = 26;
        int N = 2;
        int R = 8;
        int[] A = {45,40};
        int[] B = {17,1};
        System.out.println(solve(x,y,N,R,A,B));
    }
}
