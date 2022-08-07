/*

Source: https://leetcode.com/problems/search-in-rotated-sorted-array/

 * There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1
 
Constraints:

1) 1 <= nums.length <= 5000
2) -10^4 <= nums[i] <= 10^4
3) All values of nums are unique.
4) nums is an ascending array that is possibly rotated.
5) -10^4 <= target <= 10^4
 */
public class RotatedBinarySearch {
    public static int search(final int[] A, int B) {
        int k = 0;
        int low = 1;
        int high = A.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(A[mid]>A[0])
            {
                low = mid+1;
            }
            else if(A[mid] < A[0])
            {
                k = mid;
                high = mid-1;
            }
        }
        System.out.println("K: "+k);
        if(B >= A[0])
        {
            low = 0;
            high = k-1;
            if(k == 0)
                high = A.length-1;
        }
        else
        {
            low = k;
            high = A.length-1;
        }
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(A[mid] == B)
                return mid;
            else if(A[mid] < B)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] arr = {180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177};
        int B = 42;
        System.out.println(search(arr,B));
    }
}
