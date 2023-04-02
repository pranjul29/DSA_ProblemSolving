/* 
Source: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

Return the number of pairs of different nodes that are unreachable from each other.

Example 1:

Input: n = 3, edges = [[0,1],[0,2],[1,2]]
Output: 0
Explanation: There are no pairs of nodes that are unreachable from each other. Therefore, we return 0.
Example 2:

Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
Output: 14
Explanation: There are 14 pairs of nodes that are unreachable from each other:
[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]].
Therefore, we return 14.
 
Constraints:

1 <= n <= 10^5
0 <= edges.length <= 2 * 10^5
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated edges.
*/
import java.util.*;
public class CountUnreachableNodesInUndirectedGraph {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited;
    static void dfs(int curr,int start)
    {
        // System.out.println("CURR: " + curr + " START: " + start);
        visited[curr] = start;
        for(int i = 0;i<adj.get(curr).size();i++)
        {
            int curr_node = adj.get(curr).get(i);
            if(visited[curr_node]==-1)
                dfs(curr_node,start);
        }
    }
    public static long countPairs(int n, int[][] edges) {
        visited = new int[n];
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        Arrays.fill(visited,-1);
        // System.out.println(adj);
        long ans = 0;
        for(int i = 0;i<n;i++)
        {
            if(visited[i] == -1)
                dfs(i,i);
        }
        // for(int i = 0;i<n;i++)
        //     System.out.print(visited[i] + " ");
        // System.out.println();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++)
            map.put(visited[i],map.getOrDefault(visited[i],0) + 1);
        // System.out.println(map);
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            long value = (long)entry.getValue();
            ans += value * ((long)n-value);
        }
        return ans/2;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{0,2},{1,2}};
        System.out.println(countPairs(n,edges));
    }
}
