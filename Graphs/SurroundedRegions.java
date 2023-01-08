/* 
Source: https://leetcode.com/problems/surrounded-regions/description/
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:
Input: board = [["X"]]
Output: [["X"]]
 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
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
    public String toString(){
        return new String(this.x + " " + this.y);
    }
}
class Solution {
    public boolean isOnEdge(int x,int y,int N,int M)
    {
        if(x == 0 || x == N-1 || y == 0 || y == M-1)
            return true;
        return false;
    }
    public boolean isValid(int x,int y,int N,int M)
    {
        if(x < 0 || x >= N || y < 0 || y >= M)
            return false;
        return true;
    }
    public void solve(char[][] board) {
        int N = board.length;
        int M = board[0].length;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0;i<N;i++)
        {
            for(int j = 0;j<M;j++)
            {
                if(board[i][j] == 'O' && isOnEdge(i,j,N,M))
                {
                    queue.add(new Pair(i,j));
                }
            }
        }
        while(!queue.isEmpty())
        {
            //System.out.println(queue);
            Pair curr = queue.peek();
            queue.remove();
            board[curr.x][curr.y] = 'N';
            int[] x_n = {0,0,-1,1};
            int[] y_n = {1,-1,0,0};
            for(int i = 0;i<4;i++)
            {
                int x = curr.x + x_n[i];
                int y = curr.y + y_n[i];
                if(isValid(x,y,N,M) && board[x][y] == 'O')
                    queue.add(new Pair(x,y));
            }
        }
        for(int i = 0;i<N;i++)
        {
            for(int j = 0;j<M;j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'N')
                    board[i][j] = 'O';
                
            }
        }
    }
}
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Solution s = new Solution();
        s.solve(board);
    }
}
