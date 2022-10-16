/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34957/homework/problems/4178?navref=cl_tt_lst_nm
Source: https://leetcode.com/problems/number-of-squareful-arrays/
Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

Problem Constraints
1 <= length of the array <= 12
1 <= A[i] <= 10^9

Example Input
Input 1:
 A = [2, 2, 2]
Input 2:
 A = [1, 17, 8]

Example Output
Output 1:
 1
Output 2:
 2

Example Explanation
Explanation 1:
 Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
Explanation 2:
 Permutation are [1, 8, 17] and [17, 8, 1].
*/
import java.util.*;
public class NumberOfSquarefulArrays {
    static HashSet<ArrayList<Integer>> result;
    static void swap(int i,int j,int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static boolean isPerfectSquare(int a, int b)
    {
        int sum = a+b;
        double root = Math.sqrt(sum);
        if((root - Math.floor(root)) != 0)
            return false;
        return true;
    }
    static void generate(int[] A, int N, int pos, int[] current)
    {
        if(N == pos)
        {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = 0;i<current.length;i++)
                    temp.add(current[i]);
                result.add(temp);
                return;
        }
        for(int i = pos;i<N;i++)
        {
            // This will help in Case to Avoid Duplicate Scenario
            if(i != pos && A[i] == A[pos])
                continue;
            swap(i,pos,A);
            current[pos] = A[pos];
            if(pos==0 || (pos!=0 && isPerfectSquare(current[pos],current[pos-1])))
                generate(A,N,pos+1,current);

            swap(i,pos,A);
        }
    }
    public static int solve(int[] A) {
        if(A.length == 1)
            return 0;
        result = new HashSet<ArrayList<Integer>>();
        int[] current = new int[A.length];
        generate(A,A.length,0,current);
        return result.size();
    }
    public static void main(String[] args) {
        int[] A = {1,17,8};
        System.out.prinltn(solve(A));
    }
}
