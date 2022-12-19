/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34957/assignment/problems/4176/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/unique-paths-iii/description/
Given a matrix of integers A of size N x M . There are 4 types of squares in it:
1. 1 represents the starting square.  There is exactly one starting square.
2. 2 represents the ending square.  There is exactly one ending square.
3. 0 represents empty squares we can walk over.
4. -1 represents obstacles that we cannot walk over.
Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
2 <= N * M <= 20
-1 <= A[i] <= 2

Input Format
The first argument given is the integer matrix A.

Output Format
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Example Input
Input 1:
A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
Input 2:
A = [   [0, 1]
        [2, 0]    ]

Example Output
Output 1:
2
Output 2:
0

Example Explanation
Explanation 1:
We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Explanation 1:
Answer is evident here.
*/
public class UniquePathsIII {
    static int dfs(int[][] A, int x,int y,int zero)
    {
        if(x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == -1)
            return 0;
        if(A[x][y] == 2)
        {
            if(zero == -1)
                return 1;
            else
                return 0;
        }
        A[x][y] = -1;
        zero--;
        int[] x_n = {1,-1,0,0};
        int[] y_n = {0,0,1,-1};
        int count = 0;
        for(int i = 0;i<4;i++)
        {
            count += dfs(A,x + x_n[i],y + y_n[i],zero);
        }
        A[x][y] = 0;
        zero++;
        return count;

        
    }
    public static int solve(int[][] A) {
        int zeroes = 0;
        int sx = 0;
        int sy = 0;
        for(int i = 0;i<A.length;i++)
            for(int j = 0;j<A[0].length;j++)
            {
                if(A[i][j] == 0)
                    zeroes++;
                if(A[i][j] == 1)
                {
                    sx = i;
                    sy = j;
                }
            }
        return dfs(A,sx,sy,zeroes);
    }
    public static void main(String[] args) {
        int[][] A = {{1, 0, 0, 0},{0, 0, 0, 0},{0, 0, 2, -1}};
        System.out.println(solve(A));
    }
}
