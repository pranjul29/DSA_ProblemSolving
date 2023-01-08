/* 
Source: https://leetcode.com/problems/max-points-on-a-line/description/
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Example 1:
Input: points = [[1,1],[2,2],[3,3]]
Output: 3
Example 2:
Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
 
Constraints:
1 <= points.length <= 300
points[i].length == 2
-10^4 <= xi, yi <= 10^4
All the points are unique.
*/
import java.util.*;
public class MaxPointsOnALine {
    public static int maxPoints(int[][] points) {
        int max_ans = 0;
        for(int i = 0;i<points.length;i++)
        {
            HashMap<Double,Integer> count_on_line = new HashMap<>();
            for(int j = 0;j<points.length;j++)
            {
                if(i == j)
                    continue;
                Double atan = Math.atan2(points[i][0]-points[j][0],points[i][1]-points[j][1]);
                count_on_line.put(atan,count_on_line.getOrDefault(atan,0)+1);
                max_ans = Math.max(count_on_line.get(atan),max_ans);
            }
        }
        return max_ans+1;
    }
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(maxPoints(points));
    }
}
