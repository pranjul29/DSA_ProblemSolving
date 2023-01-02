/* 
Source: https://leetcode.com/problems/sliding-window-maximum/description/
Source: https://www.scaler.com/academy/mentee-dashboard/class/34909/assignment/problems/50/?navref=cl_pb_nv_tb
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 10^5
-104 <= nums[i] <= 10^4
1 <= k <= nums.length
*/
import java.util.*;
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> tree_map = new TreeMap<Integer, Integer>();
        for(int i = 0;i<k;i++)
        {
            if(tree_map.containsKey(nums[i]))
                tree_map.put(nums[i],tree_map.get(nums[i]) + 1);
            else
                tree_map.put(nums[i],1);
        }
        int[] result = new int[nums.length-k+1];
        result[0] = tree_map.lastKey();
        for(int i = k;i<nums.length;i++)
        {
            if(tree_map.containsKey(nums[i]))
                tree_map.put(nums[i],tree_map.get(nums[i]) + 1);
            else
                tree_map.put(nums[i],1);
            if(tree_map.get(nums[i-k]) == 1)
                tree_map.remove(nums[i-k]);
            else
                tree_map.put(nums[i-k],tree_map.get(nums[i-k])-1);
            result[i-k+1] = tree_map.lastKey();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums,k));
    }
}
