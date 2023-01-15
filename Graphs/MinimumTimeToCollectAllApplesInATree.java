/* 
Source: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.

The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.

Example 1:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8 
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
Example 2:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect all apples is shown by the green arrows.  
Example 3:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
Output: 0
 
Constraints:

1 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ai < bi <= n - 1
fromi < toi
hasApple.length == n
*/
import java.util.*;
class Pair{
    int apple = 0;
    int cost = 0;
    public Pair(int apple,int cost)
    {
        this.apple = apple;
        this.cost = cost;
    }
}
public class MinimumTimeToCollectAllApplesInATree {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static Pair dfs(int ver,boolean[] hasApple)
    {
        int apple = hasApple[ver] ? 1 : 0;
        visited[ver] = true;
        int apples = 0;
        int cost = 0;
        for(int i = 0;i<adj.get(ver).size();i++)
        {
            int curr = adj.get(ver).get(i);
            if(!visited[curr])
            {
                Pair temp = dfs(curr,hasApple);
                if(temp.apple != 0)
                {
                    apples += temp.apple;
                    cost += (temp.cost + 2);
                }
            }
        }
        return new Pair(apple+apples,cost);
    }
    public static int minTime(int n, int[][] edges, boolean[] hasApple) {
        adj = new ArrayList<>();
        visited = new boolean[n];
        for(int i = 0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Pair result = dfs(0,hasApple);
        return result.cost;
    }
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        boolean[] hasApple = {false,false,true,false,false,true,false};
        System.out.println(minTime(n,edges,hasApple));
    }
}
