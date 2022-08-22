/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/homework/problems/4117/?navref=cl_pb_nv_tb

Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.
More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.
Return an array with two elements {A[i], B[j]}.

Problem Constraints
1 <= length of both the arrays <= 100000
1 <= A[i], B[i] <= 10^9
1 <= C <= 10^9

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = [2, 4, 6, 8]
 C = 9
Input 2:
 A = [5, 10, 20]
 B = [1, 2, 30]
 C = 13
Example Output
Output 1:
 [1, 8]
Output 2:
 [10, 2]

Example Explanation
Explanation 1:
 There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
 Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].
Explanation 2:
 [10, 2] is the only pair such abs(10+2-13) is minimum.
*/
public class ClosestPairFromSortedArray {
    public static int[] solve(int[] A, int[] B, int C) {
        int i = 0;
        int j = B.length-1;
        int minimum_i = -1;
        int minimum_j = -1;
        long minimum = Integer.MAX_VALUE;
        while(i < A.length || j >=0)
        {
            long sum = A[i]*1l + B[j]*1l;
            if(sum == (long)C)
            {
                minimum = 0;
                minimum_i = i;
                minimum_j = j;
                break;
            }
            else if(sum < (long)C)
            {
                if(minimum > Math.abs(sum-C))
                {
                    minimum = Math.abs(sum-C);
                    minimum_i = i;
                    minimum_j = j;
                }
                if(minimum == Math.abs(sum-C))
                {
                    if(i < minimum_i)
                    {
                        minimum_i = i;
                        minimum_j = j;
                    }
                    else if(minimum_i == i && minimum_j > j)
                    {
                        minimum_i = i;
                        minimum_j = j;
                    }
                }
                i++;
            }
            else
            {
                if(minimum > Math.abs(sum-C))
                {
                    minimum = Math.abs(sum-C);
                    minimum_i = i;
                    minimum_j = j;
                }
                if(minimum == Math.abs(sum-C))
                {
                    if(i < minimum_i)
                    {
                        minimum_i = i;
                        minimum_j = j;
                    }
                    else if(minimum_i == i && minimum_j > j)
                    {
                        minimum_i = i;
                        minimum_j = j;
                    }
                }
                j--;
            }
            if(j < 0)
            {
                j = 0;
                i++;
                if(i >= A.length)
                {
                    break;
                }
            }
            if(i >=A.length)
            {
                i = A.length-1;
                j--;
                if(j < 0)
                {
                    break;
                }
            }
        }
        int[] arr = new int[2];
        arr[0] = A[minimum_i];
        arr[1] = B[minimum_j];
        return arr;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2,4,6,8};
        int C = 9;
        int[] result = solve(A, B, C);
        for(int i = 0;i<result.length;i++)
        {
            System.out.print(result[i]+" ");
        }
    }
}
