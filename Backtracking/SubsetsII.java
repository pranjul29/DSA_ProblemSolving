/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34957/homework/problems/146/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/subsets-ii/
Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.

Problem Constraints
0 <= N <= 16

Example Input
Input 1:
 A = [1, 2, 2]
Input 2:
 A = [1, 1]

Example Output
Output 1:
 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]
Output 2:
 [
    [],
    [1],
    [1, 1]
 ]

Example Explanation
Explanation 1:
All the subsets of the array [1, 2, 2] in lexicographically sorted order.
*/
import java.util.*;
public class SubsetsII {
    static HashSet<ArrayList<Integer>> result;
    public static void generate(ArrayList<Integer> A, int N, int pos,ArrayList<Integer> temp)
    {
        if(N == pos)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        generate(A,N,pos+1,temp);
        temp.add(A.get(pos));
        generate(A,N,pos+1,temp);
        temp.remove(temp.size()-1);
    }
    public static  ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        result = new HashSet<>();
        Collections.sort(A);
        ArrayList<Integer> temp = new ArrayList<>();
        generate(A,A.size(),0,temp);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(result);
        Collections.sort(res, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            else if(second.size()>first.size())
                return -1;
            else
                return 0;
        });
        return res;
    }    
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,2));
        System.out.println(subsetsWithDup(A));
    }
}
