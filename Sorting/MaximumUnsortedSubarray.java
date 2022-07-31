/*
Source: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Example 2:

Input: nums = [1,2,3,4]
Output: 0

Example 3:

Input: nums = [1]
Output: 0

Constraints:

1) 1 <= nums.length <= 10^4
2) -10^5 <= nums[i] <= 10^5

 */
package Sorting;
import java.util.*;
public class MaximumUnsortedSubarray {
    public static int findUnsortedSubarray(int[] A) {
        int[] temp = new int[A.length];
        for(int i = 0;i<A.length;i++)
        {
            temp[i] = A[i];
        }
        Arrays.sort(temp);
        int left_index = -1;
        for(int i = 0;i<A.length;i++)
        {
            if(A[i]!=temp[i])
            {
                left_index = i;
                break;
            }
        }
        int right_index = -1;
        for(int i = A.length-1;i>=0;i--)
        {
            if(A[i]!=temp[i])
            {
                right_index = i;
                break;
            }
        }
        if(left_index == -1)
            return 0;
        return right_index-left_index+1;
    }

    public static void main(String[] aStrings)
    {
        int[] arr = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(arr));
    }
}
