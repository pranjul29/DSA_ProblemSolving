/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34997/assignment/problems/4704/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/rotting-oranges/
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

Problem Constraints
1 <= N, M <= 1000
0 <= A[i][j] <= 2

Input Format
The first argument given is the integer matrix A.

Output Format
Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.
Example Input
Input 1:
A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]

Example Output
Output 1:
 4
Output 2:
 -1

Example Explanation
Explanation 1:
 Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
Explanation 2:
 Task is impossible
*/
import java.util.*;
class Pair{
    int x;
    int y;
    public Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class RottenOranges {
    static boolean checkIfValid(int i ,int j,int n,int m)
    {
        if(i < 0 || j < 0 || i >= n || j >=m)
            return false;
        return true;
    }
    public static int solve(int[][] A) {
        Queue<Pair> queue = new LinkedList<>();
        int n = A.length;
        int m = A[0].length;
        for(int i = 0;i< n ;i++)
        {
            for(int j = 0; j < m;j++)
            {
                if(A[i][j] == 2)
                    queue.add(new Pair(i,j));
            }
        }
        int level = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i<size;i++)
            {
                Pair curr = queue.peek();
                queue.remove();
                int[] x_n = {1,-1,0,0};
                int[] y_n = {0,0,-1,1};
                for(int j = 0;j<4;j++)
                {
                    int x = curr.x + x_n[j];
                    int y = curr.y + y_n[j];
                    if(checkIfValid(x,y,n,m) && A[x][y] == 1)
                    {
                        A[x][y] = 2;
                        queue.add(new Pair(x,y));
                    }
                }
            }
            level++;
        }
        for(int i = 0;i< n ;i++)
        {
            for(int j = 0; j < m;j++)
            {
                if(A[i][j] == 1)
                    return -1;
            }
        }
        return level-1;
    }
    public static void main(String[] args) {
        int[][] A = {{2, 1, 1},{1, 1, 0},{0, 1, 1}};
        System.out.println(solve(A));
    }
}
