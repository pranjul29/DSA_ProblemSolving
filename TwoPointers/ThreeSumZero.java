/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29510/assignment/problems/170/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/3sum/

Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.

Problem Constraints

0 <= N <= 7000
-10^8 <= A[i] <= 10^8

Example Input
A = [-1,0,1,2,-1,4]

Example Output
[ [-1,0,1],
  [-1,-1,2] ]
*/
import java.util.*;
public class ThreeSumZero {
    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        for(int k = 0;k<A.size();k++)
        {
            int a = A.get(k);
            int target = -a;
            int i = k+1;
            int j = A.size()-1;
            while(i<j)
            {
                int temp = A.get(i) + A.get(j);
                if(temp == target)
                {
                    ArrayList<Integer> temp_result = new ArrayList<>();
                    temp_result.add(a);
                    temp_result.add(A.get(i));
                    temp_result.add(A.get(j));
                    result.add(temp_result);
                    i++;
                    j--;
                    //temp_result.clear();
                }
                else if(temp < target)
                {
                    i++;
                }
                else
                    j--;
            }
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
    public static void main(String[] args) {
        int[] arr = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
        ArrayList<Integer> A = new ArrayList<>();
        for(int i = 0;i<arr.length;i++)
            A.add(arr[i]);
        System.out.println(threeSum(A));
    }
}
