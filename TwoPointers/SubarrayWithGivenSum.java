/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/assignment/problems/4116?navref=cl_tt_lst_nm

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:
 A = [5, 10, 20, 100, 105]
 B = 110
Example Output
Output 1:
 [2, 3]
Output 2:
 -1

Example Explanation
Explanation 1:
 [2, 3] sums up to 5.
Explanation 2:
 No subarray sums up to required number.
*/
public class SubarrayWithGivenSum {
    public static int[] solve(int[] A, int B) {
        long[] pf = new long[A.length];
        pf[0] = A[0];
        for(int i = 1;i<A.length;i++)
            pf[i] = pf[i-1] + (long)A[i];
        // if(pf[0] == B)
        // {
        //     int[] result = new int[1];
        //     result[0] = A[0];
        //     return result;
        // }
        int i = -1;
        int j = 0;
        int flag = 0;
        while(j<A.length)
        {
            long diff = 0;
            if(i == -1)
                diff = pf[j];
            else
                diff = pf[j]-pf[i];
            if(diff == (long)B)
            {
                flag = 1;
                break;
            }
            else if(diff < (long)B)
                j++;
            else
                i++;
            if(i == j)
                j++;
        }
        if(flag == 0)
        {
            int[] result = {-1};
            return result;
        }
        int[] result = new int[j-i];
        i++;
        for(int k = 0;k<result.length;k++)
        {
            result[k] = A[i];
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 100, 105};
        int B = 110;
        System.out.println(solve(arr, B));
    }
}
