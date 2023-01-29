/* 
Source: https://leetcode.com/problems/find-the-town-judge/description/
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 
Constraints:
1 <= n <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n
*/
import java.util.*;
public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        if(n == 1 && trust.length == 0)
            return 1;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int ans = -1;
        for(int i = 0;i<trust.length;i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if(map.containsKey(trust[i][1]))
            {
                temp = map.get(trust[i][1]);
            }
            temp.add(trust[i][0]);
            map.put(trust[i][1],temp);
            set.add(trust[i][0]);
        }
        // System.out.println(map);
        // System.out.println(set);
        for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet())
        {
            if(entry.getValue().size() == n-1 && !set.contains(entry.getKey()))
            {
                ans = entry.getKey();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1,2}};
        System.out.println(findJudge(n,trust));
    }
}
