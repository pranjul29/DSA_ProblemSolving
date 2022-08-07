/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29506/homework/problems/872/?navref=cl_pb_nv_tb


Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).

NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.

Example:
A : [2 1 4 3 2]
k : 3
Answer : 2

Constraints :
1 <= number of elements in the price list <= 1000000
1 <= k <= number of elements in the price list

*/
class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public boolean checkValid(int[] A,int mid,int B)
    {
        int count = 0;
        for(int i =0;i<A.length;i++)
        {
            if(A[i] <= mid)
                count++;
            if(count == B)
                return true;
        }
        return false;
    }
    public int solve(final int[] A, int B) {
        int high = A[0];
        int low = A[0];
        for(int i = 1;i<A.length;i++)
        {
            if(A[i] > high)
            {
                high = A[i];
            }
            if(A[i] < low)
            {
                low = A[i];
            }
        }
        System.out.println("High: "+high+" Low: "+low);
        int ans = 0;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            System.out.println("Mid: "+mid+" Ans: "+ans);
            if(checkValid(A,mid,B))
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
            System.out.println("Mid: "+mid+" Ans: "+ans);
        }
        return ans;
    }
}

public class KthPrice {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2,1,4,3,2};
        System.out.println(s.solve(arr, 3));
    }
}
