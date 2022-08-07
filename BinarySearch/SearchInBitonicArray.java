/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29506/homework/problems/10901/?navref=cl_pb_nv_tb
Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:
A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Problem Constraints
3 <= N <= 10^5
1 <= A[i], B <= 10^8
Given array always contain a bitonic point.
Array A always contain distinct elements.

Example Input
Input 1:
 A = [3, 9, 10, 20, 17, 5, 1]
 B = 20
Input 2:
 A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 B = 30

Example Output
Output 1:
 3
Output 2:
 -1

Example Explanation
Explanation 1:
 B = 20 present in A at index 3
Explanation 2:
 B = 30 is not present in A

*/
class Solution {
    public int solve(int[] A, int B) {
        int bitonic_point = 0;
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
        low = 0;
        high = bitonic_point;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(A[mid] == B)
                return mid;
            else if(A[mid]>B)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        low = bitonic_point;
        high = N-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(A[mid] == B)
                return mid;
            else if(A[mid]>B)
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
}
public class SearchInBitonicArray {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5, 6, 7, 8, 9, 10, 3, 2, 1};
        System.out.println(s.solve(arr, 3));
    }   
}
