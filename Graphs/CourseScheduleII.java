/* 
Source: https://leetcode.com/problems/course-schedule-ii/description/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]
 
Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
*/
import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++)
            adj.add(new ArrayList<Integer>());
        for(int i = 0;i<prerequisites.length;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<indegree.length;i++)
            if(indegree[i] == 0)
                queue.add(i);
        ArrayList<Integer> results = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int curr = queue.peek();
            queue.remove();
            results.add(curr);
            for(int i = 0;i<adj.get(curr).size();i++)
            {
                indegree[adj.get(curr).get(i)]--;
                if(indegree[adj.get(curr).get(i)] == 0)
                    queue.add(adj.get(curr).get(i));
            }
        }
        if(results.size() != numCourses)
            return new int[0];
        int[] result = new int[results.size()];
        for(int i = 0;i<results.size();i++)
            result[i] = results.get(i);
        return result;
    }
}
public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 2; 
        int[][] prerequisites = {{1,0}};
        Solution s = new Solution();
        s.findOrder(numCourses, prerequisites);
    }
}
