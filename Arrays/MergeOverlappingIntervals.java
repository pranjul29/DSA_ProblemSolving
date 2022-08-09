/*

Source: https://www.scaler.com/academy/mentee-dashboard/class/29456/assignment/problems/61
Source: https://leetcode.com/problems/merge-intervals/
Given a collection of intervals, merge all overlapping intervals.

Constraints:
1 <= Total number of intervals <= 100000.

Example Input
Input 1:
[1,3],[2,6],[8,10],[15,18]

Example Output
Output 1:
[1,6],[8,10],[15,18]

Example Explanation
Explanation 1:
Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.

*/
import java.util.*;
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class MergeOverlappingIntervals {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        result.add(intervals.get(0));
        for(int i = 1;i<intervals.size();i++)
        {
            Interval curr = intervals.get(i);
            int j = 0;
            int N = result.size();
            while(j<N && j>=0)
            {
                if((curr.start > result.get(j).end) || (curr.end < result.get(j).start))
                { 
                    result.add(curr);
                    j++;
                }
                else
                {
                    curr.start = Math.min(curr.start,result.get(j).start);
                    curr.end = Math.max(curr.end,result.get(j).end);
                    result.remove(j);
                    N--;
                }
            }
            if(N<=0)
                result.add(curr);
        }
        Set<Interval> result_set = new LinkedHashSet<Interval>(result);
        result = new ArrayList<Interval>(result_set); 
        Collections.sort(result, (a,b) -> {
            if(a.start == b.start)
            {
                if(a.end < b.end)
                    return -1;
                else
                    return 1;
            }
            else if(a.start < b.start)
                return -1;
            else
                return 1;
        });
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        System.out.println(merge(intervals));
    }
    
}
