/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34997/assignment/problems/11843/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/cycle-in-undirected-graph/
Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.
Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
NOTE:
The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
1 <= A, M <= 3*10^5
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].

Output Format
Return 1 if cycle is present else return 0.

Example Input
Input 1:
 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]
Input 2:
 A = 3
 B = [  [1. 2]
        [1, 3]
     ]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1
Explanation 2:
 No cycle present in the graph so we will return 0.
*/
import java.util.*;
public class CycleInUndirectedGraph {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited;
    static boolean isCyclic;
    static void dfs(int curr, int parent)
    {
        visited[curr] = 1;
        for(int i = 0;i<adj.get(curr).size();i++)
        {
            int neigh = adj.get(curr).get(i);
            if(visited[neigh] == 1 && neigh!=parent)
                isCyclic = true;
            if(visited[neigh] == 0)
                dfs(neigh,curr);
        }
    }
    public static int solve(int A, int[][] B) {
        isCyclic = false;
        adj = new ArrayList<>();
        visited = new int[A+1];
        for(int i = 0;i<=A;i++)
            adj.add(new ArrayList<>());
        for(int i = 0;i<B.length;i++)
        {
            adj.get(B[i][0]).add(B[i][1]);
            adj.get(B[i][1]).add(B[i][0]);
        }
        for(int i = 1;i<=A;i++)
        {
            if(visited[i]!=1)
                dfs(i,-1);
        }
        if(isCyclic)
            return 1;
        return 0;
    }
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2},{1, 3},{2, 3},{1, 4},{4, 5}};
        System.out.println(solve(A,B));
    }

}
