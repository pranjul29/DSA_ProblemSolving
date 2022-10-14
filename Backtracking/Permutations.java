/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34957/assignment/problems/138/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/permutations/
Given an integer array A of size N denoting collection of numbers , return all possible permutations.
NOTE:
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.

Problem Constraints
1 <= N <= 9

Example Input
A = [1, 2, 3]
Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3] 
  [2, 3, 1] 
  [3, 1, 2] 
  [3, 2, 1] ]
Example Explanation
All the possible permutation of array [1, 2, 3].
*/
public class Permutations {
    static int[][] result;
    static int counter = 0;
    static void swap(int i,int j,int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void generate(int[] A, int N, int pos, int[] current)
    {
        if(N == pos)
        {
            for(int i = 0;i<N;i++)
            {
                result[counter][i] = current[i];
            }
            counter++;
            return;
        }
        for(int i = pos;i<N;i++)
        {
            swap(i,pos,A);
            current[pos] = A[pos];
            generate(A,N,pos+1,current);
            swap(i,pos,A);
        }
    }
    public static int[][] permute(int[] A) {
        int factorial = 1;
        for(int i = A.length;i>=1;i--)
            factorial = factorial*i;
        result = new int[factorial][A.length];
        int[] current = new int[A.length];
        generate(A,A.length,0,current);
        return result;
    }    
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        System.out.println(permute(A));
    }
}
