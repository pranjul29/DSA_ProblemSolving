/* 
Source: https://leetcode.com/problems/as-far-from-land-as-possible/description/?envType=study-plan&id=graph-i
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

Example 1:

Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:

Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 
Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1

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
public class AsFarFromLandAsPossible {
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x<0 || y < 0 || x >=n || y >=m)
            return false;
        return true;
    }
    public static int maxDistance(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++)
            for(int j = 0;j<m;j++)
                if(grid[i][j] == 1)
                    queue.add(new Pair(i,j));
        int ans = 0;
        int[][] visited = new int[n][m];
        while(!queue.isEmpty())
        {
            // System.out.println(queue);
            Pair curr = queue.peek();
            queue.remove();
            if(visited[curr.x][curr.y] == 1)
                continue;
            visited[curr.x][curr.y] = 1;
            int[] x_n = {1,-1,0,0};
            int[] y_n = {0,0,-1,1};
            for(int i = 0;i<4;i++)
            {
                int x = x_n[i] + curr.x;
                int y = y_n[i] + curr.y;
                if(isValid(x,y,n,m) && grid[x][y] == 0)
                {
                    grid[x][y] = grid[curr.x][curr.y] + 1;
                    ans = Math.max(ans,grid[x][y]);
                    queue.add(new Pair(x,y));
                }
            }
        }
        // for(int i = 0;i<n;i++)
        // {
        //     for(int j = 0;j<m;j++)
        //         System.out.print(grid[i][j] + " ");
        //     System.out.println();
        // }
        return ans-1;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
        System.out.println(maxDistance(grid));
    }
}
