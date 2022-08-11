/*
Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9 
1 <= B <= 10^9
For Example
Input 1:
    A = [1, 2, 3, 4, 5]
    B = 5
Output 1:
    2

Input 2:
    A = [5, 10, 20, 100, 105]
    B = 110
Output 2:
    2
*/
public class CountPairsWithGivenSum {
    public static int solve(int[] A, int B) {
        int l = 0;
        int r = A.length-1;
        int count = 0;
        while(l<r)
        {
            int a = A[l];
            int b = A[r];
            if(a+b == B)
            {
                count++;
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
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 100, 105};
        int B = 110;
        System.out.println(solve(arr, B));
    }
}
