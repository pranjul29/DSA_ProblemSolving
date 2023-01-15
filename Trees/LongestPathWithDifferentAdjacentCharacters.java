/* 
Source: https://leetcode.com/problems/longest-path-with-different-adjacent-characters/description/
You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.

You are also given a string s of length n, where s[i] is the character assigned to node i.

Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.

Example 1:
Input: parent = [-1,0,0,1,1,2], s = "abacbe"
Output: 3
Explanation: The longest path where each two adjacent nodes have different characters in the tree is the path: 0 -> 1 -> 3. The length of this path is 3, so 3 is returned.
It can be proven that there is no longer path that satisfies the conditions. 
Example 2:
Input: parent = [-1,0,0,0], s = "aabc"
Output: 3
Explanation: The longest path where each two adjacent nodes have different characters is the path: 2 -> 0 -> 3. The length of this path is 3, so 3 is returned.
 
Constraints:
n == parent.length == s.length
1 <= n <= 10^5
0 <= parent[i] <= n - 1 for all i >= 1
parent[0] == -1
parent represents a valid tree.
s consists of only lowercase English letters.
*/
import java.util.*;
public class LongestPathWithDifferentAdjacentCharacters {
    static ArrayList<ArrayList<Integer>> adj;
    static int longest_ans = Integer.MIN_VALUE;
    public static int longestPathAcrossCurrNode(int ver,String s,int par)
    {
        int n = adj.get(ver).size();
        int[] curr_results = new int[n];
        for(int i = 0;i<n;i++)
            curr_results[i] = longestPathAcrossCurrNode(adj.get(ver).get(i),s,ver);
        Arrays.sort(curr_results);
        int ans = 1;
        if(n-1 >= 0)
            ans += Math.max(0,curr_results[n-1]);
        if(n-2 >= 0)
            ans += Math.max(0,curr_results[n-2]);
        longest_ans = Math.max(ans,longest_ans);
        if(par == -1)
            return longest_ans;
        if(s.charAt(par) != s.charAt(ver))
        {
            int curr_ans = 1;
            if(n-1 >= 0)
                curr_ans += Math.max(0,curr_results[n-1]);
            return curr_ans;
        }
        else
            return 0;
    }
    public static int longestPath(int[] parent, String s) {
        adj = new ArrayList<>();
        int N = parent.length;
        for(int i = 0;i<N;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 1;i<N;i++)
            adj.get(parent[i]).add(i);
        return longestPathAcrossCurrNode(0,s,-1);
    }
    public static void main(String[] args) {
        int[] parent = {-1,0,0,1,1,2};
        String s = new String("abacbe");
        System.out.println(longestPath(parent,s));
    }
}
