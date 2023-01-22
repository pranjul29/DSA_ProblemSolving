/* 
Source: https://leetcode.com/problems/number-of-operations-to-make-network-connected/description
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.


Example 1:


Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 

Constraints:

1 <= n <= 10^5
1 <= connections.length <= min(n * (n - 1) / 2, 10^5)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable.
*/
import java.util.*;
public class NumberOfOperationsToMakeNetworkConnected {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited;
    static void dfs(int index)
    {
        visited[index] = 1;
        for(int i = 0;i<adj.get(index).size();i++)
        {
            int curr = adj.get(index).get(i);
            if(visited[curr] == 0)
                dfs(curr);
        }
    }
    public static int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges < n-1)
            return -1;
        visited = new int[n];
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<connections.length;i++)
        {
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            if(visited[i] == 0)
            {
                dfs(i);
                count++;
            }
        }
        return count-1;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0,1},{0,2},{1,2}};
        System.out.println(makeConnected(n,connections));
    }
}
