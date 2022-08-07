/*
Source: https://leetcode.com/problems/peak-index-in-a-mountain-array/
An array arr a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
You must solve it in O(log(arr.length)) time complexity.

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1
 
Constraints:
3 <= arr.length <= 10^5
0 <= arr[i] <= 10^6
arr is guaranteed to be a mountain array.
*/
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int bitonic_point = -1;
        int low = 0;
        int N = A.length;
        int high = N-1;
        if(A[0] > A[1])
            bitonic_point = 0;
        else if(A[N-1] > A[N-2])
            bitonic_point = N-1;
        else
        {
            low = 1;
            high = N-2;
            while(low<=high)
            {
                int mid = low + (high-low)/2;
                if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
                {
                    bitonic_point = mid;
                    break;
                }
                else if(mid!=0 && mid!=(N-1) && A[mid]>A[mid-1] && A[mid]<A[mid+1])
                {
                    low = mid+1;
                }
                else if(mid!=0 && mid!=(N-1) && A[mid]>A[mid+1] && A[mid-1]>A[mid])
                {
                    high = mid-1;
                }
            }
        }
        return bitonic_point;
    }
}
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5, 6, 7, 8, 9, 10, 3, 2, 1};
        System.out.println(s.peakIndexInMountainArray(arr));
    }
}
