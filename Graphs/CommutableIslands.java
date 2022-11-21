/* 
Source; https://www.scaler.com/academy/mentee-dashboard/class/35005/assignment/problems/376/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/commutable-islands/
There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
We need to find bridges with minimal cost such that all islands are connected.
It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

Problem Constraints
1 <= A, M <= 6*10^4
1 <= B[i][0], B[i][1] <= A
1 <= B[i][2] <= 10^3

Input Format
The first argument contains an integer, A, representing the number of islands.
The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].

Output Format
Return an integer representing the minimal cost required.

Example Input
Input 1:
 A = 4
 B = [  [1, 2, 1]
        [2, 3, 4]
        [1, 4, 3]
        [4, 3, 2]
        [1, 3, 10]  ]
Input 2:
 A = 4
 B = [  [1, 2, 1]
        [2, 3, 2]
        [3, 4, 4]
        [1, 4, 3]   ]

Example Output
Output 1:
 6
Output 2:
 6

Example Explanation
Explanation 1:
 We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
Explanation 2:
 We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
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
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(node);
        str.append(" ");
        str.append(weight);
        return str.toString();
    }
}
public class CommutableIslands {
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
        System.out.println(adj);
        for(int i = 0;i<adj.get(1).size();i++)
        {
            heap.add(adj.get(1).get(i));
        }
        visited[1] = 1;
        int ans = 0;
        while(!heap.isEmpty())
        {
            System.out.println(heap);
            Pair curr = heap.peek();
            heap.poll();
            if(visited[curr.node]==1)
                continue;
            ans += curr.weight;
            visited[curr.node] = 1;
            for(int i = 0;i<adj.get(curr.node).size();i++)
                heap.add(adj.get(curr.node).get(i));
        }
        return ans;
    }   
    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1,2,10},{2,3,5},{1,3,9}};
        System.out.println(solve(A,B));
    }
}
