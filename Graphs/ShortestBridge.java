/* 
Source: https://leetcode.com/problems/shortest-bridge/description/?envType=study-plan&id=graph-i
You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 1
Example 2:
Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:
Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 
Constraints:

n == grid.length == grid[i].length
2 <= n <= 100
grid[i][j] is either 0 or 1.
There are exactly two islands in grid.
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
    public String toString()
    {
        return new String(this.x + " " + this.y);
    }
}
public class ShortestBridge {
    static int[][] visited;
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x < 0 || y < 0 || x >=n || y >= m)
            return false;
        return true;
    }
    static void dfs(int x,int y,int[][] grid,int n,int m)
    {
        grid[x][y] = 2;
        visited[x][y] = 1;
        int[] x_n = {1,-1,0,0};
        int[] y_n = {0,0,-1,1};
        for(int i = 0;i<4;i++)
        {
            int curr_x = x_n[i] + x;
            int curr_y = y_n[i] + y;
            if(isValid(curr_x,curr_y,n,m) && visited[curr_x][curr_y] == 0 && grid[curr_x][curr_y] == 1)
                dfs(curr_x,curr_y,grid,n,m);
        }
    }
    public static int shortestBridge(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        visited = new int[n][m];
        int[][] distance = new int[n][m];
        boolean flag = false;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
                if(grid[i][j] == 1)
                {
                    dfs(i,j,grid,n,m);
                    flag = true;
                    break;
                }
            if(flag)
                break;
        }
        for(int i = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                if(grid[i][j] == 1 && visited[i][j] == 0)
                    queue.add(new Pair(i,j));
        while(!queue.isEmpty())
        {
            Pair curr = queue.peek();
            queue.remove();
            int[] x_n = {1,-1,0,0};
            int[] y_n = {0,0,-1,1};
            for(int i = 0;i<4;i++)
            {
                int x = x_n[i] + curr.x;
                int y = y_n[i] + curr.y;
                if(isValid(x,y,n,m) && grid[x][y] == 0 && visited[x][y] == 0)
                {
                    visited[x][y] = 1;
                    distance[x][y] = distance[curr.x][curr.y] + 1;
                    queue.add(new Pair(x,y));
                }
                if(isValid(x,y,n,m) && grid[x][y] == 2)
                    return distance[curr.x][curr.y];
            }
        }
        // for(int i = 0;i<n;i++)
        // {
        //     for(int j = 0;j<m;j++)
        //         System.out.print(distance[i][j] + " ");
        //     System.out.println();
        // }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{0,0,0},{0,0,1}};
        System.out.println(shortestBridge(grid));
    }
}
