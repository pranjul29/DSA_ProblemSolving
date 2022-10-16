/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34957/assignment/problems/134/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/permutations-ii/
Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
NOTE: No 2 entries in the permutation sequence should be the same.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.

Problem Constraints
1 <= |A| <= 9
0 <= A[i] <= 10

Example Input
Input 1:
A = [1, 1, 2]
Input 2:
A = [1, 2]

Example Output
Output 1:
[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Output 2:
[ [1, 2]
  [2, 1] ]

Example Explanation
Explanation 1:
 All the possible unique permutation of array [1, 1, 2].
Explanation 2:
 All the possible unique permutation of array [1, 2].
*/
import java.util.*;
public class PermutationsTwo {
    static ArrayList<ArrayList<Integer>> result;
    static void swap(int a,int b,ArrayList<Integer> arr)
    {
        int temp = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,temp);
        System.out.println("Swapping Values at i:"+a+" and j:"+b+" A:"+arr);
    }
    static void generate(ArrayList<Integer> A, int N,int pos,ArrayList<Integer> current)
    {
        if(N == pos)
        {
            result.add(new ArrayList<>(current));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = pos;i<N;i++)
        {
            if(set.contains(A.get(i)))
                continue;
            set.add(A.get(i));
            swap(i,pos,A);
            current.add(A.get(pos));
            generate(A,N,pos+1,current);
            swap(i,pos,A);
            current.remove(current.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        generate(A,A.size(),0,current);
        return result;
    }   
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,2));
        System.out.println(permute(A));
    } 
}
