/* 
Source: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.
Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Example 2:
Input: nums = [5], k = 9
Output: 0
 
Constraints:
1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
2 <= k <= 10^4
*/
import java.util.*;
public class SubarraySumDivisbleByK {
    public static int getMod(int n,int k)
    {
        while(n<0)
            n = n + k;
        return n%k;
    }
    public static int subarraysDivByK(int[] nums, int k) {
        nums[0] = getMod(nums[0],k);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        int count = 0;
        if(nums[0] == 0)
            count++;
        for(int i = 1;i<nums.length;i++)
        {
            // System.out.println(map);
            nums[i] = getMod(nums[i] + nums[i-1],k);
            if(nums[i] == 0)
                count++;
            if(map.containsKey(nums[i]))
                count += map.get(nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(nums,5));
    }
}
