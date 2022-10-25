/*
Source: https://leetcode.com/problems/contains-duplicate-ii/
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 
Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5
*/
import java.util.*;
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> set = new HashMap<>();
        for(int i = 0;i<=k && i < nums.length;i++)
        {
            set.put(nums[i],set.getOrDefault(nums[i],0)+1);
        }
        if(nums.length <= k)
        {
            if(set.size() < nums.length)
                return true;
        }
        else
        {
            if(set.size() < k+1)
                return true;
        }
        for(int i = k+1;i<nums.length;i++)
        {
            set.put(nums[i-k-1],set.get(nums[i-k-1])-1);
            if(set.get(nums[i-k-1]) == 0)
                set.remove(nums[i-k-1]);
            set.put(nums[i],set.getOrDefault(nums[i],0)+1);
            if(set.size()<k+1)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }
}
