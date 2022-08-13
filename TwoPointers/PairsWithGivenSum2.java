/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/assignment/problems/5097/?navref=cl_pb_nv_tb

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (10^9 + 7).

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Example Input
Input 1:
A = [1, 1, 1]
B = 2
Input 2:
A = [1, 1]
B = 2

Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:
 Any two pairs sum up to 2.
Explanation 2:
 only pair (1, 2) sums up to 2.
*/
public class PairsWithGivenSum2 {
    public static int solve(int[] A, int B) {
        int l = 0;
        int r = A.length-1;
        long count = 0;
        while(l<r)
        {
            int a = A[l];
            int b = A[r];
            if(a+b == B)
            {
                long left = 1;
                while(l!= (A.length-1) && A[l] == A[l+1])
                {
                    left++;
                    l++;
                }
                long right = 1;
                while(r!= 0 && A[r] == A[r-1])
                {
                    right++;
                    r--;
                }
                if(a == b)
                    count+=(left*(left-1)/2);
                else
                    count += left*right;
                l++;
                r--;
            }
            else if(a+b < B)
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        count = count%(1000000007);
        return (int)count;
    }
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 4, 5, 6, 7, 10};
        int B = 8;
        System.out.println(solve(arr, B));;
    }
}
