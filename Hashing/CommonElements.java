/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29514/homework/problems/10203/?navref=cl_pb_nv_tb
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
NOTE:
Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.

Problem Constraints
1 <= N, M <= 10^5
1 <= A[i] <= 10^9

Example Input
Input 1:
 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:
 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]

Example Output
Output 1:
 [1, 2, 2]
Output 2:
 [2, 10]

Example Explanation
Explanation 1:
 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:
 Elements (2, 10) appears in both the array.
*/
import java.util.*;
public class CommonElements {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<A.size();i++)
        {
            hm.put(A.get(i),hm.getOrDefault(A.get(i),0)+1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<B.size();i++)
        {
            if(hm.containsKey(B.get(i)))
            {
                int temp = hm.get(B.get(i));
                if(temp == 1)
                    hm.remove(B.get(i));
                else
                    hm.put(B.get(i),temp-1);
                result.add(B.get(i));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(2);A.add(1);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(2);B.add(3);B.add(1);B.add(2);
        System.out.println(solve(A, B));
    }
}

