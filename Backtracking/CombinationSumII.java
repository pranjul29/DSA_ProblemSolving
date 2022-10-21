/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34961/homework/problems/140?navref=cl_tt_lst_nm
Source: https://leetcode.com/problems/combination-sum-ii/

Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
Each number in A may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Warning:

DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.

Problem Constraints
1 <= N <= 20

Example Input
Input 1:
 A = [10, 1, 2, 7, 6, 1, 5]
 B = 8
Input 2:
 A = [2, 1, 3]
 B = 3

Example Output
Output 1:
 [ 
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ], 
  [2, 6 ] 
 ]
Output 2:
 [
  [1, 2 ],
  [3 ]
 ]

Example Explanation
Explanation 1:
 1 + 1 + 6 = 8
 1 + 2 + 5 = 8
 1 + 7 = 8
 2 + 6 = 8
 All the above combinations sum to 8 and are arranged in ascending order.
Explanation 2:
 1 + 2 = 3
 3 = 3
 All the above combinations sum to 3 and are arranged in ascending order.
*/
import java.util.*;
public class CombinationSumII {
    static HashSet<ArrayList<Integer>> result;
    static void generate(ArrayList<Integer> A,int B,int pos,ArrayList<Integer> temp)
    {
        if(B == 0)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        if(B < 0 || pos>=A.size())
            return;
        int i = pos+1;
        while(i < A.size())
        {
            if(A.get(i)!=A.get(i-1))
                break;
            i++;
        }
        generate(A,B,i,temp);
        temp.add(A.get(pos));
        generate(A,B-A.get(pos),pos+1,temp);
        temp.remove(temp.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        result = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Collections.sort(A);
        generate(A,B,0,temp);
        return new ArrayList<>(result);
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        int B = 8;
        System.out.println(combinationSum(A,B));
    }
}
