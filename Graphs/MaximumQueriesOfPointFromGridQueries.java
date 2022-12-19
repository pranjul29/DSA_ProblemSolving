/* 
Source: https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/
You are given an m x n integer matrix grid and an array queries of size k.
Find an array answer of size k such that for each integer queres[i] you start in the top left cell of the matrix and repeat the following process:
If queries[i] is strictly greater than the value of the current cell that you are in, then you get one point if it is your first time visiting this cell, and you can move to any adjacent cell in all 4 directions: up, down, left, and right.
Otherwise, you do not get any points, and you end this process.
After the process, answer[i] is the maximum number of points you can get. Note that for each query you are allowed to visit the same cell multiple times.
Return the resulting array answer.

Example 1:

Input: grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
Output: [5,8,1]
Explanation: The diagrams above show which cells we visit to get points for each query.
Example 2:

Input: grid = [[5,2,1],[1,1,2]], queries = [3]
Output: [0]
Explanation: We can not get any points because the value of the top left cell is already greater than or equal to 3.
 
Constraints:
m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 10^5
k == queries.length
1 <= k <= 10^4
1 <= grid[i][j], queries[i] <= 10^6
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
public class MaximumQueriesOfPointFromGridQueries {
    public static boolean isValid(int x,int y,int N,int M)
    {
        if(x < 0 || y < 0 || x >= N || y >= M)
            return false;
        return true;
    }
    public static int[] maxPoints(int[][] grid, int[] queries) {
        int N = grid.length;
        int M = grid[0].length;
        int k = queries.length;
        int[] result = new int[k];
        int[] sample_queries = new int[k];
        for(int i = 0;i<k;i++)
            sample_queries[i] = queries[i];
        Arrays.sort(queries);
        HashMap<Integer,Integer> map_ans = new HashMap<>();
        Queue<Pair> bfs = new PriorityQueue<>((a,b) -> {
            return grid[a.x][a.y] - grid[b.x][b.y];
        });
        bfs.offer(new Pair(0,0));
        int[][] visited = new int[N][M];
        visited[0][0] = 1;
        int curr_ans = 0;
        for(int i = 0;i<k;i++)
        {
            while(!bfs.isEmpty() && queries[i] > grid[bfs.peek().x][bfs.peek().y])
            {
                curr_ans++;
                Pair curr = bfs.peek();
                bfs.poll();
                int[] x_n = {1,-1,0,0};
                int[] y_n = {0,0,-1,1};
                for(int j = 0;j<4;j++)
                {
                    int x = x_n[j] + curr.x;
                    int y = y_n[j] + curr.y;
                    if(isValid(x,y,N,M) && visited[x][y] == 0)
                    {
                        visited[x][y] = 1;
                        bfs.offer(new Pair(x,y));
                    }
                }
            }
            map_ans.put(queries[i],curr_ans);
        }
        for(int i = 0;i<k;i++)
        {
            result[i] = map_ans.get(sample_queries[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{2,5,7},{3,5,1}};
        int[] queries = {5,6,2};
        int[] result = maxPoints(grid,queries);
    }
}
