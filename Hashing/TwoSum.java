/* 
Source: https://leetcode.com/problems/two-sum/description/?envType=study-plan&id=level-1
Source: https://www.scaler.com/academy/mentee-dashboard/class/24896/assignment/problems/157/?navref=cl_pb_nv_tb

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 
Constraints:
2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.
 
Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/
import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
            map.put(nums[i],i);
        int first = -1;
        int last = -1;
        for(int i = 0;i<nums.length;i++)
        {
            first = i;
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!= i )
            {
                last = map.get(target-nums[i]);
                break;
            }
        }
        int[] result = {first,last};
        Arrays.sort(result);
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums,target));
    }
}
