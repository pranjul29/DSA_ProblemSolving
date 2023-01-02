/* 
Source: https://leetcode.com/problems/all-paths-from-source-to-target/description/

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Example 1:
Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:
Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 
Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.
*/
import java.util.*;
public class AllPathsFromSourceToTarget {
    static ArrayList<ArrayList<Integer>> adj;
    static List<List<Integer>> answer;
    static int[] visited;
    static void generateAllPaths(int curr,int target,List<Integer> temp)
    {
        if(curr == target)
        { 
            answer.add(new ArrayList<>(temp));
            return;
        }
        visited[curr] = 1;
        for(int i = 0;i<adj.get(curr).size();i++)
        {
            temp.add(adj.get(curr).get(i));
            generateAllPaths(adj.get(curr).get(i),target,temp);
            temp.remove(temp.size()-1);
        }
        visited[curr] = 0;
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        adj = new ArrayList<>();
        answer = new ArrayList<>();
        int n = graph.length;
        visited = new int[n];
        for(int i = 0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i = 0;i<graph.length;i++)
        {
            for(int j = 0;j<graph[i].length;j++)
            {
                adj.get(i).add(graph[i][j]);
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        generateAllPaths(0,n-1,temp);
        return answer;
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
}
