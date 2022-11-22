/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/35005/assignment/problems/9240?navref=cl_tt_lst_nm

Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
NOTE: Return the answer modulo 10^9+7 as the answer can be large.

Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 10^9

Input Format
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]

Output Format
Return an integer denoting the minimum construction cost.

Example Input
Input 1:
A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:
A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]

Example Output
Output 1:
9
Output 2:
37

Example Explanation
Explanation 1:
We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph. 
we can reach the 1st node from 2nd and 3rd node using only these two edges.
So, the total cost of costruction is 9.
Explanation 2:
We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
*/
import java.util.*;
class Pair{
    int weight;
    int node;
    public Pair(int weight,int node)
    {
        this.weight = weight;
        this.node = node;
    }
}
public class ConstructionCost {
    public static int solve(int A, int[][] B) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> {
            return a.weight-b.weight;
        });
        int[] visited = new int[A+1];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=A;i++)
            adj.add(new ArrayList<Pair>());
        for(int i = 0;i<B.length;i++)
        {
            adj.get(B[i][0]).add(new Pair(B[i][2],B[i][1]));
            adj.get(B[i][1]).add(new Pair(B[i][2],B[i][0]));
        }
        for(int i = 0;i<adj.get(1).size();i++)
        {
            heap.add(adj.get(1).get(i));
        }
        visited[1] = 1;
        int M = 1000000007;
        long ans = 0;
        while(!heap.isEmpty())
        {
            Pair curr = heap.peek();
            heap.poll();
            if(visited[curr.node]==1)
                continue;
            ans += (long)curr.weight;
            visited[curr.node] = 1;
            for(int i = 0;i<adj.get(curr.node).size();i++)
                heap.add(adj.get(curr.node).get(i));
            ans = ans%M;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1, 2, 14}, {2, 3, 7},{3, 1, 2}};
        System.out.println(solve(A, B));
    }
}
