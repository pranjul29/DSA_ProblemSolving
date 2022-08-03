/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29506/assignment/problems/4133/?navref=cl_pb_nv_tb
Source: 
Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 10
Input 2:
A = [5, 17, 100, 11]
B = 130

Example Output
Output 1:
 2
Output 2:
 3

*/
public class SpecialInteger {
    public static int solve(int[] A, int B) {
        int low = 1;
        int high = A.length;
        int ans = 0;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            long sum = maxSubarrayK(A,mid);
            if(sum <= (long)B)
            {
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;

    }
    public static long maxSubarrayK(int[] A,int K)
    {
        long sum = 0;
        long max_sum = 0;
        for(int i = 0;i<K && i<A.length;i++)
        {
            sum = sum + A[i];
        }
        max_sum = sum;
        for(int i = K;i<A.length;i++)
        {
            sum = sum + A[i] - A[i-K];
            if(sum > max_sum)
            {
                max_sum = sum;
            }
        }
        return max_sum;
    }
    public static void main(String[] args)
    {
        int[] arr = {5, 17, 100, 11};
        int B = 130;
        System.out.println(solve(arr,B));
    }
}
