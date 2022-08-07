/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29508/assignment/problems/4129/?navref=cl_pb_nv_tb

Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 10^9
2 <= B <= N

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 3
Input 2:
A = [1, 2]
B = 2

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
Explanation 2:
 The minimum distance will be 1.
*/
import java.util.*;
class Solution {
    public boolean checkValid(int[] A,int mid,int B)
    {
        int last_cow = A[0];
        int c = 1;
        for(int i = 1;i<A.length;i++)
        {
            if(A[i] - last_cow >= mid)
            {
                c++;
                last_cow = A[i];
                if(c == B)
                    return true;
            }
        }
        return false;
    }
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int low = A[1]-A[0];
        int high = A[A.length-1]-A[0];
        for(int i = 2;i<A.length;i++)
        {
            int diff = A[i]-A[i-1];
            if(diff<low)
                low = diff;
        }
        int ans = 0;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(checkValid(A,mid,B))
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
}

public class AggressiveCows {
    public static void main(String[] args) {
        Solution s  = new Solution();
        int[] arr = {1,2,3,4,5};
        int B = 3;
        System.out.println(s.solve(arr, B));
    }
}
