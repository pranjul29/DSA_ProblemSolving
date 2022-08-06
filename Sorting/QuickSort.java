/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29502/assignment/problems/10863/?navref=cl_pb_nv_tb
Given an integer array A, sort the array using QuickSort.

Constraints: 
1 <= |A| <= 10^5
1 <= A[i] <= 10^9

Example Input
Input 1:
 A = [1, 4, 10, 2, 1, 5]
Input 2:
 A = [3, 7, 1]

Example Output
Output 1:
 [1, 1, 2, 4, 5, 10]
Output 2:
 [1, 3, 7]


*/
class Solution {
    public void swap(int[] A,int l,int r)
    {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }
    public int rearrange(int[] A,int s,int e)
    {
        int l = s+1;
        int r = e;
        while(l<=r)
        {
            if(A[l]<=A[s])
                l++;
            else if(A[r]>=A[s])
                r--;
            else
            {
                swap(A,l,r);
                l++;
                r--;
            }
        }
        swap(A,s,r);
        return r;
    }
    public void quickSort(int[] A,int s,int e)
    {
        if(s>=e)
            return;
        int index = rearrange(A,s,e);
        quickSort(A,s,index-1);
        quickSort(A,index+1,e);
    }
    public int[] solve(int[] A) {
        quickSort(A,0,A.length-1);
        return A;
    }
}
public class QuickSort{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1, 4, 10, 2, 1, 5};
        A = s.solve(A);
        for(int i = 0;i<A.length;i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }
}
