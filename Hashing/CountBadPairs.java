/*
Source: https://leetcode.com/problems/count-number-of-bad-pairs/
You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
Return the total number of bad pairs in nums.

Example 1:
Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5.

Example 2:
Input: nums = [1,2,3,4,5]
Output: 0
Explanation: There are no bad pairs.

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
*/
import java.util.*;
class Solution {
    public long countBadPairs(int[] nums) {
        for(int i = 0;i<nums.length;i++)
            nums[i] = nums[i] - i;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        long count = 0;
        for (Map.Entry<Integer,Integer> entry : hm.entrySet()) 
        {
            int temp = entry.getValue();
            count = count + ((temp*1L)*(temp - 1L)/2L);
        }
        return nums.length*1L*(nums.length-1L)/2L - count;
    }
}
public class CountBadPairs {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,7,12,18,3,6,8,10,15};
        System.out.println(s.countBadPairs(nums));
    }   
}
