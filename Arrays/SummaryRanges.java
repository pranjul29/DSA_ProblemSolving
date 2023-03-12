/* 
Source: https://leetcode.com/problems/summary-ranges/description/
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 
Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 
Constraints:

0 <= nums.length <= 20
-2^31 <= nums[i] <= 2^31 - 1
All the values of nums are unique.
nums is sorted in ascending order.
*/
import java.util.*;
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        int first = 0;
        int last = 0;
        List<String> result = new ArrayList<>();
        if(nums.length == 0)
            return result;
        for(int i = 1;i<nums.length;i++)
        {
            if(nums[i] == nums[i-1] + 1)
            {
                last = i;
            }
            else
            {
                StringBuilder str = new StringBuilder("");
                str.append(nums[first]);
                if(first != last)
                {
                    str.append("->");
                    str.append(nums[last]);
                }
                result.add(str.toString());
                first = i;
                last = i;
            }
        }
        StringBuilder str = new StringBuilder("");
        str.append(nums[first]);
        if(first != last)
        {
            str.append("->");
            str.append(nums[last]);
        }
        result.add(str.toString());
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,8,9,11};
        System.out.println(summaryRanges(nums));
    }
}
