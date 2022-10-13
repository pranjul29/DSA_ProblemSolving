/*
Source: https://leetcode.com/problems/increasing-triplet-subsequence/
Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 
Constraints:
1 <= nums.length <= 5 * 10^5
-2^31 <= nums[i] <= 2^31 - 1

Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?

Python Code:
def increasingTriplet(nums):
    first = second = float('inf')
    for n in nums:
        if n <= first:
            first = n
        elif n <= second:
            second = n
        else:
            return True
    return False
    
*/
public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int[] smallest_so_far = new int[nums.length];
        smallest_so_far[0] = nums[0];
        for(int i = 1;i<nums.length;i++)
            smallest_so_far[i] = Math.min(nums[i],smallest_so_far[i-1]);
        int[] largest_so_far = new int[nums.length];
        largest_so_far[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2;i>=0;i--)
            largest_so_far[i] = Math.max(largest_so_far[i+1],nums[i]);
        for(int i = 1;i<nums.length-1;i++)
        {
            if(nums[i]!=smallest_so_far[i] && nums[i]!=largest_so_far[i])
                return true;
        }
        return false;
    }    
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }
}
