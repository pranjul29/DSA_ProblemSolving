/*
Source: https://leetcode.com/problems/sort-colors/
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/homework/problems/167/hints?navref=cl_pb_nv_tb

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
 
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
*/
public class SortColors {
    public static void sortColors(int[] nums) {
        int start = 0;
        int k = nums.length-1;
        for(int i = 0;i<=k;)
        {
            if(nums[i] == 0)
            {
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i++;
            }
            else if(nums[i] == 2)
            {
                nums[i] = nums[k];
                nums[k] = 2;
                k--;
            }
            else
                i++;
        }   
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2};
        sortColors(arr);
        System.out.println(arr);
    }
}
