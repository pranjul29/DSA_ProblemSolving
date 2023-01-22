/* 
Source: https://leetcode.com/problems/shortest-path-with-alternating-colors/description/?envType=study-plan&id=graph-i
You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.

Example 1:

Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
Output: [0,1,-1]
Example 2:

Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
Output: [0,1,-1]
 
Constraints:

1 <= n <= 100
0 <= redEdges.length, blueEdges.length <= 400
redEdges[i].length == blueEdges[j].length == 2
0 <= ai, bi, uj, vj < n
*/
import java.util.*;
class Pair{
    int index;
    boolean isRed;
    int length;
    public Pair(int index,boolean isRed,int length)
    {
        this.index = index;
        this.isRed = isRed;
        this.length = length;
    }
    public String toString()
    {
        return new String(this.index + " " + this.isRed + " " + this.length);
    }
}
public class ShortestPathWithAlternatingColors {
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Integer>> adj_red = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj_blue = new ArrayList<>();
        for(int i = 0;i<n;i++)
        {
            adj_red.add(new ArrayList<Integer>());
            adj_blue.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<redEdges.length;i++)
            adj_red.get(redEdges[i][0]).add(redEdges[i][1]);
        for(int i = 0;i<blueEdges.length;i++)
            adj_blue.get(blueEdges[i][0]).add(blueEdges[i][1]);
        int[][] results = new int[n][2];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,true,0));
        queue.add(new Pair(0,false,0));
        for(int i = 0;i<results.length;i++)
        {
            results[i][0] = -1;
            results[i][1] = -1;
        }
        while(!queue.isEmpty())
        {
            Pair curr =queue.peek();
            queue.remove();
            if(curr.isRed)
            {
                if(results[curr.index][0] != -1)
                    continue;
                results[curr.index][0] = curr.length;
            }
            else
            {
                if(results[curr.index][1] != -1)
                    continue;
                results[curr.index][1] = curr.length;
            }
            if(curr.isRed)
            {
                for(int i = 0;i<adj_blue.get(curr.index).size();i++)
                {
                    if(results[adj_blue.get(curr.index).get(i)][1] == -1)
                        queue.add(new Pair(adj_blue.get(curr.index).get(i),false,curr.length+1));
                }
            }
            else
            {
                for(int i = 0;i<adj_red.get(curr.index).size();i++)
                    if(results[adj_red.get(curr.index).get(i)][0] == -1)
                        queue.add(new Pair(adj_red.get(curr.index).get(i),true,curr.length+1));
            }
        }
        int[] result = new int[n];
        for(int i = 0;i<results.length;i++)
        {
            if(results[i][0] == -1 && results[i][1] == -1)
                result[i] = -1;
            else if(results[i][0] == -1)
                result[i] = results[i][1];
            else if(results[i][1] == -1)
                result[i] = results[i][0];
            else 
                result[i] = Math.min(results[i][0],results[i][1]);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] redEdges = {{0,1}};
        int[][] blueEdges = {{2,1}};
        System.out.println(shortestAlternatingPaths(n,redEdges,blueEdges));
    }
}
