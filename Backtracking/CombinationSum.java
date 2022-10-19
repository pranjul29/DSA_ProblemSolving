/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34961/homework/problems/136/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/combination-sum/
Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
The same repeated number may be chosen from A unlimited number of times.
Note:
1) All numbers (including target) will be positive integers.
2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3) The combinations themselves must be sorted in ascending order.
4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
5) The solution set must not contain duplicate combinations.

Problem Constraints
1 <= |A| <= 20
1 <= A[i] <= 50
1 <= B <= 500

Example Input
Input 1:
A = [2, 3]
B = 2
Input 2:
A = [2, 3, 6, 7]
B = 7
Example Output
Output 1:
[ [2] ]
Output 2:
[ [2, 2, 3] , [7] ]

Example Explanation
Explanation 1:
All possible combinations are listed.
Explanation 2:
All possible combinations are listed.
*/
import java.util.*;
public class CombinationSum {
    static ArrayList<ArrayList<Integer>> result;
    static int target;
    static void findCombination(ArrayList<Integer> A,ArrayList<Integer> temp,int sum,int index)
    {
        if(sum == target)
        {
            ArrayList<Integer> curr = new ArrayList<>(temp);
            Collections.sort(curr);
            result.add(new ArrayList<>(curr));
            return;
        }
        if(sum > target)
        {
            return;
        }
        for(int i = index;i<A.size();i++)
        {
            sum = sum + A.get(i);
            temp.add(A.get(i));
            findCombination(A,temp,sum,i);
            sum -= A.get(i);
            temp.remove(temp.size()-1);
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        result = new ArrayList<>();
        HashSet<Integer> a = new HashSet<Integer>(A);
        A = new ArrayList<Integer>(a);
        Collections.sort(A);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        target = B;
        findCombination(A,temp,0,0);
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,3,6,7));
        int B = 7;
        System.out.println(combinationSum(A,B));
    }
}
