/* 
Source: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance of a road in this path.

Return the minimum possible score of a path between cities 1 and n.

Note:

A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
The test cases are generated such that there is at least one path between 1 and n.
 
Example 1:

Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
Output: 5
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
It can be shown that no other path has less score.
Example 2:

Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
Output: 2
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
 
Constraints:

2 <= n <= 10^5
1 <= roads.length <= 10^5
roads[i].length == 3
1 <= ai, bi <= n
ai != bi
1 <= distancei <= 10^4
There are no repeated edges.
There is at least one path between 1 and n.
*/
import java.util.*;
class Pair{
    int weight;
    int node;
    public Pair(int weight,int node)
    {
        this.weight = weight;
        this.node = node;
    }
    public String toString()
    {
        return new String("(" + this.weight + " " + this.node + ")");
    }
}
public class MinimumScoreOfAPathBetweenTwoCities {
    static ArrayList<ArrayList<Pair>> adj;
    static int[] visited;
    
    public static void dfs(int node)
    {
        visited[node] = 1;
        for(int i = 0;i<adj.get(node).size();i++)
        {
            int curr_node = adj.get(node).get(i).node;
            int curr_weight = adj.get(node).get(i).weight;
            if(visited[curr_node] == 1)
                continue;
            dfs(curr_node);
        }
    }
    public static int minScore(int n, int[][] roads) {
        visited = new int[n+1];
        adj = new ArrayList<>();
        for(int i = 0;i<=n;i++)
            adj.add(new ArrayList<Pair>());
        for(int i = 0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(new Pair(roads[i][2],roads[i][1]));
            adj.get(roads[i][1]).add(new Pair(roads[i][2],roads[i][0]));
        }
        dfs(1);
        int ans = Integer.MAX_VALUE;
        for(int i = 1;i<=n;i++)
        {
            if(visited[i] == 1)
            {
                for(int j = 0;j<adj.get(i).size();j++)
                {
                    int curr_weight = adj.get(i).get(j).weight;
                    ans = Math.min(ans, curr_weight);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        System.out.println(minScore(n,roads));
    }
}
