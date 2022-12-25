/* 
Source: https://leetcode.com/problems/possible-bipartition/description/
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.

Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 
Constraints:
1 <= n <= 2000
0 <= dislikes.length <= 10^4
dislikes[i].length == 2
1 <= dislikes[i][j] <= n
ai < bi
All the pairs of dislikes are unique.
*/
import java.util.*;
public class PossibleBipartite {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] colors;
    static boolean isBipartite = true;
    public static void biPartite(int color,int n)
    {
        colors[n] = color;
        // for(int i = 0;i<colors.length;i++)
        //     System.out.print(colors[i] + " ");
        // System.out.println();
        for(int i = 0;i<adj.get(n).size();i++)
        {
            if(colors[adj.get(n).get(i)] == color)
            {
                isBipartite = false;
            }
            if(colors[adj.get(n).get(i)] == -1)
                biPartite(1-color,adj.get(n).get(i));
        }
    }
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        adj = new ArrayList<>();
        colors = new int[n+1];
        Arrays.fill(colors,-1);
        for(int i = 0;i<=n;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<dislikes.length;i++)
        {
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        for(int i = 1;i<=n;i++)
        {
            if(colors[i] == -1)
                biPartite(0,i);
        }
        
        if(isBipartite)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] dislikes = {{1,2},{2,3},{3,4},{4,5},{1,5}};
        System.out.println(possibleBipartition(n,dislikes));
    }
}
