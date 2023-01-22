/* 
Source: https://leetcode.com/problems/pacific-atlantic-water-flow/description/
There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

Example 1:

Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.
Example 2:

Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 
Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 10^5
*/
import java.util.*;
public class PacificAtlanticWaterFlow {
    static List<List<Integer>> result;
    static boolean[][] pacific;
    static boolean[][] atlantic;
    static int[][] visited;
    static boolean isValid(int x,int y,int n,int m)
    {
        if(x < 0 || y < 0 || x>=n || y>=m)
            return false;
        return true;
    }
    static void isPossibleToFlow(int x,int y,int[][] heights)
    {
        int n = heights.length;
        int m = heights[0].length;
        if(visited[x][y] == 4)
            return;
        visited[x][y] += 1;
        if(x-1 < 0 || y-1 < 0)
            pacific[x][y] = true;
        if((x+1) >= n || (y+1) >= m)
            atlantic[x][y] = true;
        int[] x_n = {1,-1,0,0};
        int[] y_n = {0,0,-1,1};
        for(int i = 0;i<4;i++)
        {
            
            int curr_x = x + x_n[i];
            int curr_y = y + y_n[i];
            if(isValid(curr_x,curr_y,n,m) && heights[curr_x][curr_y] <= heights[x][y])
            {
                isPossibleToFlow(curr_x,curr_y,heights);

            }
            if(isValid(curr_x,curr_y,n,m)  && heights[curr_x][curr_y] <= heights[x][y])
            {
                atlantic[x][y] = atlantic[x][y] || atlantic[curr_x][curr_y];
                pacific[x][y] = pacific[x][y] || pacific[curr_x][curr_y];
            }
        }
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        pacific = new boolean[n][m];
        atlantic = new boolean[n][m];
        visited = new int[n][m];
        result = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(visited[i][j] == 0)
                    isPossibleToFlow(i,j,heights);
            }
        }
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                if(pacific[i][j] && atlantic[i][j])
                {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }
}
