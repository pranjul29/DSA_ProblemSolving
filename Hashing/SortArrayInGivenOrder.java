/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29512/homework/problems/4808/?navref=cl_pb_nv_tb
Source: https://leetcode.com/problems/relative-sort-array/
Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
For the elements not present in B, append them at last in sorted order.
Return the array A after sorting from the above method.
NOTE: Elements of B are unique.

Problem Constraints
1 <= length of the array A <= 100000
1 <= length of the array B <= 100000
-10^9 <= A[i] <= 10^9

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [5, 4, 2]
Input 2:
A = [5, 17, 100, 11]
B = [1, 100]

Example Output
Output 1:
[5, 4, 2, 1, 3]
Output 2:
[100, 5, 11, 17]

Example Explanation
Explanation 1:
 Simply sort as described.
Explanation 2:
 Simply sort as described.
*/
import java.util.*;
public class SortArrayInGivenOrder {
    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer,Integer> b = new HashMap<>();
        for(int i = 0;i<B.length;i++)
        {
            b.put(B[i],i);
        }
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> not_present = new ArrayList<>();
        for(int i = 0;i<A.length;i++)
        {
            if(b.containsKey(A[i]))
                a.add(A[i]);
            else
                not_present.add(A[i]);
        }
        Collections.sort(a,(a1,a2)-> (b.get(a1) < b.get(a2)) ? -1 :
                                       (b.get(a1) > b.get(a2)) ? 1 : 0);
        Collections.sort(not_present);
        for(int i = 0;i<not_present.size();i++)
        {
            a.add(not_present.get(i));
        }
        int[] result = a.stream().mapToInt(i -> i).toArray();
        return result;
    }
    public static void main(String[] args) {
        int[] A = {5, 17, 100, 11};
        int[] B = {1,100};
        System.out.println(solve(A, B));
    }
}
