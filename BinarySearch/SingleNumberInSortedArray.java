/*
Source: https://leetcode.com/problems/single-element-in-a-sorted-array/description/
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 
Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
*/
public class SingleNumberInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = (high-low)/2 + low;
            if(mid%2 == 0)
            {
                if(mid<n-1 && nums[mid] == nums[mid+1])
                    low = mid+2;
                else if(mid > 0 && nums[mid] == nums[mid-1])
                    high = mid-2;
                else
                    return nums[mid];
            }
            else
            {
                if(mid<n-1 && nums[mid] == nums[mid+1])
                    high = mid-1;
                else if(mid > 0 && nums[mid] == nums[mid-1])
                    low = mid+1;
                else
                    return nums[mid];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {3,3,6,6,10,11,11};
        System.out.println(singleNonDuplicate(nums));
    }
}
