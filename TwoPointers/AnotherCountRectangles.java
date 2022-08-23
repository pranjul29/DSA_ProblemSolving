/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/homework/problems/4115/?navref=cl_pb_nv_tb
Given a sorted array of distinct integers A and an integer B, find and return how many rectangles with distinct configurations can be created using elements of this array as length and breadth whose area is lesser than B.
(Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Example Input
Input 1:
 A = [1, 2]
 B = 5
Input 2:
 A = [1, 2]
 B = 1

Example Output
Output 1:
 4
Output 2:
 0

Example Explanation
Explanation 1:
 All 1X1, 2X2, 1X2 and 2X1 have area less than 5.
Explanation 2:
 No Rectangle is valid.
*/
public class AnotherCountRectangles {
    public static int solve(int[] A, int B) {
        if(B == 1)
            return 0;
        int M = 1000000007;
        long count = 0;
        int i = 0;
        int j = A.length-1;
        while(i<=j)
        {
            long product = (long)A[i] * (long)A[j];
            if(product < (long)B)
            {
                long size = (long)(j-i+ 1);
                count = (count + ((size)*2 - 1))%M;
                i++;
            }
            else
                j--;
        }
        return (int)(count%M);
    }
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 100, 105};
        int B = 110;
        System.out.println(solve(arr, B));
    }
}
