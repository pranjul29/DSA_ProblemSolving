/* 
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 
Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
*/
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
public class ShortestPathInBinaryMatrix {
    static int[][] distance;
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x < 0 || y < 0 || x>=n || y>=m)
            return false;
        return true;
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return -1;
        int[] x_n = {1,-1,0,0,1,-1,1,-1};
        int[] y_n = {0,0,-1,1,1,-1,-1,1};
        distance = new int[n][m];
        int[][] visited = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        distance[0][0] = 1;
        visited[0][0] = 1;
        while(!queue.isEmpty())
        {
            //System.out.println(queue);
            Pair curr = queue.peek();
            queue.remove();
            for(int i = 0;i<8;i++)
            {
                int x = x_n[i] + curr.x;
                int y = y_n[i] + curr.y;
                if(isValid(x,y,n,m) && visited[x][y] == 0 && grid[x][y] == 0)
                {
                    distance[x][y] = distance[curr.x][curr.y] + 1;
                    queue.add(new Pair(x,y));
                    visited[x][y] = 1;
                }
            }
            // for(int i = 0;i<n;i++)
            // {
            //     for(int j = 0;j<m;j++)
            //         System.out.print(distance[i][j] + " ");
            //     System.out.println();
            // }
        }
        if(distance[n-1][m-1] == 0)
            return -1;
        return distance[n-1][m-1];
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
