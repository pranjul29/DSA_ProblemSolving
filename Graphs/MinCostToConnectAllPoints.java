/* 
Source: https://leetcode.com/problems/min-cost-to-connect-all-points/description/
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

Example 1:

Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 
We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:
Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18

Constraints:
1 <= points.length <= 1000
-106 <= xi, yi <= 10^6
All pairs (xi, yi) are distinct.
*/
import java.util.*;
class Pair{
    int point;
    int dist;
    public Pair(int point,int dist)
    {
        this.point = point;
        this.dist = dist;
    }
    public String toString()
    {
        return new String(this.point + " " + this.dist);
    }
}
class Solution {
    int findDistance(int x1,int y1, int x2,int y2)
    {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<N;i++)
        {
            adj.add(new ArrayList<Pair>());
            for(int j = 0;j<N;j++)
            {
                if(i == j)
                    continue;
                adj.get(i).add(new Pair(j,findDistance(points[i][0],points[i][1],points[j][0],points[j][1])));
            }
        }
        //System.out.println(adj);
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> {
            return a.dist - b.dist;
        });
        int cost = 0;
        for(int i = 0;i<adj.get(0).size();i++)
            queue.add(adj.get(0).get(i));
        int[] visited = new int[N];
        visited[0] = 1;
        while(!queue.isEmpty())
        {
            //System.out.println(queue);
            Pair curr = queue.peek();
            queue.poll();
            if(visited[curr.point] == 1)
                continue;
            visited[curr.point] = 1;
            cost += curr.dist;
            for(int i = 0;i<adj.get(curr.point).size();i++)
            {
                Pair child = adj.get(curr.point).get(i);
                if(visited[child.point] == 0)
                    queue.add(child);
            }
        }
        return cost;
    }
}
public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        Solution s = new Solution();
        System.out.println(s.minCostConnectPoints(points));
    }
}
