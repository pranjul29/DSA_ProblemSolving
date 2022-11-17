/* 
Source: https://leetcode.com/problems/find-if-path-exists-in-graph/
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
You want to determine if there is a valid path that exists from vertex source to vertex destination.
Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

Example 1:
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
Example 2:
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 
Constraints:
1 <= n <= 2 * 10^5
0 <= edges.length <= 2 * 10^5
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.
*/
import java.util.*;
public class PathInUndirectedGraph {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited;
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int node)
    {
        visited[node] = 1;
        for(int i = 0;i<adj.get(node).size();i++)
        {
            int neighbour = adj.get(node).get(i);
            if(visited[neighbour]!=1)
                dfs(adj,neighbour);
        }
    }
    public static boolean validPath(int A, int[][] B, int source, int destination) {
        adj = new ArrayList<>();
        visited = new int[A+1];
        for(int i = 0;i<=A;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<B.length;i++)
        {
            adj.get(B[i][0]).add(B[i][1]);
            adj.get(B[i][1]).add(B[i][0]);
        }    
        dfs(adj,source);
        if(visited[destination] == 1)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(validPath(A,B,0,5));
    }
}

