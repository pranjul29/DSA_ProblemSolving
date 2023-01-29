/* 
Source: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 
Constraints:
1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 10^4
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
*/
import java.util.*;
class Pair{
    int dest;
    int cost;
    public Pair(int dest,int cost)
    {
        this.dest = dest;
        this.cost = cost;
    }
    public String toString()
    {
        return new String(this.dest + " " + this.cost);
    }
}
class Jumps{
    Pair p;
    int jumps;
    public Jumps(Pair p,int jumps)
    {
        this.p = p;
        this.jumps = jumps;
    }
    public String toString()
    {
        return new String(this.p + " " + this.jumps);
    }
}
public class CheapestFlightWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
            adj.add(new ArrayList<Pair>());
        for(int i = 0;i<flights.length;i++)
        {
            int source = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];
            adj.get(source).add(new Pair(dest,cost));
        }
        PriorityQueue<Jumps> queue = new PriorityQueue<>((a,b) -> {
            return a.p.cost - b.p.cost;
        });
        for(int i = 0;i<adj.get(src).size();i++)
            queue.add(new Jumps(adj.get(src).get(i),0));
        int[][] visited = new int[n][n+1];
        int ans = -1;
        while(!queue.isEmpty())
        {
            Jumps curr = queue.peek();
            queue.remove();
            if(curr.jumps > k)
                continue;
            if(visited[curr.p.dest][curr.jumps] == 1)
                continue;
            visited[curr.p.dest][curr.jumps] = 1;
            if(curr.p.dest == dst)
            {
                if(ans == -1)
                    ans = curr.p.cost;
                else
                    ans = Math.min(ans,curr.p.cost);
            }
            int curr_pos = curr.p.dest;
            for(int i = 0;i<adj.get(curr_pos).size();i++)
            {
                if(visited[adj.get(curr_pos).get(i).dest][curr.jumps+1] == 1)
                    continue;
                Pair temp = adj.get(curr_pos).get(i);
                queue.add(new Jumps(new Pair(temp.dest,temp.cost+curr.p.cost),curr.jumps+1));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 3,  src = 0, dst = 2, k = 0;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }
}
