/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34957/assignment/problems/148/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/subsets/
Given a set of distinct integers A, return all possible subsets.
NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.

Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX

Example Input
Input 1:
A = [1]
Input 2:
A = [1, 2, 3]

Example Output
Output 1:
[
    []
    [1]
]
Output 2:
[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]

Example Explanation
Explanation 1:
 You can see that these are all possible subsets.
Explanation 2:
You can see that these are all possible subsets.
*/
import java.util.*;
public class Subset {
    static ArrayList<ArrayList<Integer>> result;
    public static void generate(ArrayList<Integer> A, int N, int pos,ArrayList<Integer> temp)
    {
        if(N == pos)
        {
            result.add((ArrayList)temp.clone());
            return;
        }
        generate(A,N,pos+1,temp);
        temp.add(A.get(pos));
        generate(A,N,pos+1,temp);
        temp.remove(temp.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        result = new ArrayList<>();
        Collections.sort(A);
        ArrayList<Integer> temp = new ArrayList<>();
        generate(A,A.size(),0,temp);
        Collections.sort(result, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.size() == 0)
                    return -1;
                else if(o2.size() == 0)
                    return 1;
                else
                {
                    int l1 = 0;
                    int l2 = 0;
                    while(l1!=o1.size() && l2!=o2.size())
                    {
                        if(o1.get(l1) == o2.get(l2))
                        {
                            l1++;
                            l2++;
                        }
                        else
                        {
                            return o1.get(l1).compareTo(o2.get(l2));
                        }
                    }
                    if(l1==o1.size())
                        return -1;
                    else if(l2 == o2.size())
                        return 1;
                    else
                        return 0;
                }
            }
        });
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(subsets(arr));
    }
}
