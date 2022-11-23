/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/35001/assignment/problems/9328/?navref=cl_pb_nv_tb

Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
Return the topological ordering of the graph and if it doesn't exist then return an empty array.
If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
NOTE:
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
Problem Constraints
2 <= A <= 10^4
1 <= M <= min(100000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.

Example Input
Input 1:
 A = 6
 B = [  [6, 3] 
        [6, 1] 
        [5, 1] 
        [5, 2] 
        [3, 4] 
        [4, 2] ]
Input 2:
 A = 3
 B = [  [1, 2]
        [2, 3] 
        [3, 1] ]

Example Output
Output 1:
 [5, 6, 1, 3, 4, 2]
Output 2:
 []

Example Explanation
Explanation 1:
 The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
Explanation 2:
 The given graph contain cycle so topological ordering not possible we will return empty array.
*/
import java.util.*;
public class TopologicalSort {
    public static int[] solve(int A, int[][] B) {
        int[] indegree = new int[A+1];
        Arrays.fill(indegree,0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=A;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<B.length;i++)
        {
            indegree[B[i][1]]++;
            adj.get(B[i][0]).add(B[i][1]);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1;i<indegree.length;i++)
        {
            if(indegree[i] == 0)
                queue.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(queue.size() == 0)
        {
            int[] arr = {};
            return arr;
        }
        while(!queue.isEmpty())
        {
            int curr = queue.peek();
            result.add(curr);
            queue.poll();
            for(int i = 0;i<adj.get(curr).size();i++)
            {
                int neigh = adj.get(curr).get(i);
                indegree[neigh]--;
                if(indegree[neigh] == 0)
                    queue.add(neigh);
            }
        }
        int[] ret = new int[result.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = result.get(i).intValue();
        }
        return ret;
    }
    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{6, 3}, {6, 1}, {5, 1}, {5, 2}, {3, 4}, {4, 2}};
        System.out.println(solve(A, B));
    }
}
