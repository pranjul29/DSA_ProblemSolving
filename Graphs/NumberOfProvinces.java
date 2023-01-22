/* 
Source: https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan&id=graph-i
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
*/
import java.util.*;
public class NumberOfProvinces {
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
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new int[n];
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<n;i++)
            for(int j = 0;j<n;j++)
                if(isConnected[i][j] == 1)
                    adj.get(i).add(j);
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            if(visited[i] == 0)
            {
                dfs(i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}
