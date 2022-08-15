/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29512/assignment/problems/4202?navref=cl_tt_lst_nm
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, else return 0.

Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [-1, 1]

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 No subarray has sum 0.
Explanation 2:
 The array has sum 0.
*/
import java.util.*;
public class SubArrayWithZeroSum {
    public static int solve(int[] A) {
        long[] pf = new long[A.length];
        pf[0] = (long)A[0];
        if (pf[0] == 0)
            return 1;
        for(int i = 1;i<A.length;i++)
        {
            pf[i] = pf[i-1] + (long)A[i];
            if(pf[i] == 0)
                return 1;
            if(A[i] == 0)
                return 1;
        }
        HashMap<Long,Integer> hm = new HashMap<>();
        for(int i = 0;i<pf.length;i++)
        {
            if(hm.containsKey(pf[i]))
                return 1;
            else
                hm.put(pf[i],i);
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(solve(arr));
    }
}
