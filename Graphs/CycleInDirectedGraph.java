/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/35001/homework/problems/9327/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/cycle-in-directed-graph/
Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
NOTE:
The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 10^5
1 <= M <= min(200000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return 1 if cycle is present else return 0.

Example Input
Input 1:
 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:
 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:
 The given graph doesn't contain any cycle.
*/
import java.util.*;
public class CycleInDirectedGraph {
    public static int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[A+1];
        Arrays.fill(indegree,0);
        for(int i = 0;i<=A;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<B.length;i++)
        {
            adj.get(B[i][0]).add(B[i][1]);
            indegree[B[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<=A;i++)
        {
            if(indegree[i] == 0)
                queue.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int curr = queue.peek();
            result.add(curr);
            queue.remove();
            for(int i = 0;i<adj.get(curr).size();i++)
            {
                indegree[adj.get(curr).get(i)]--;
                if(indegree[adj.get(curr).get(i)] == 0)
                    queue.add(adj.get(curr).get(i));
            }
        }
        if(result.size() == A)
            return 0;
        return 1;
    }
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2},{4, 1},{2, 4},{3, 4},{5, 2},{1, 3}};
        System.out.println(solve(A, B));
    }
}
/*
public class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int[] visited;
    boolean isCyclic;
    void dfs(int A)
    {
        visited[A] = 1;
        for(int i = 0;i<adj.get(A).size();i++)
        {
            int neigh = adj.get(A).get(i);
            if(visited[neigh] == 1)
                isCyclic = true;
            if(visited[neigh] == 0)
                dfs(neigh);
        }
        visited[A] = 2;
    }
    public int solve(int A, int[][] B) {
        adj = new ArrayList<>();
        visited = new int[A+1];
        for(int i = 0;i<=A;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<B.length;i++)
        {
            adj.get(B[i][0]).add(B[i][1]);
        }
        isCyclic = false;
        for(int i = 1;i<=A;i++)
        {
            if(visited[i] == 0)
                dfs(i);
        }
        
        
        if(isCyclic)
            return 1;
        return 0;
    }
}
*/