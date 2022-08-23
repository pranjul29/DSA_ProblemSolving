/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/29512/assignment/problems/333/?navref=cl_pb_nv_tb
Source: https://www.interviewbit.com/problems/distinct-numbers-in-window/

You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
NOTE: if B > N, return an empty array.

Example Input
Input 1:
 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:
 A = [1, 1, 2, 2]
 B = 1

Example Output
Output 1:
 [2, 3, 3, 2]
Output 2:
 [1, 1, 1, 1]

Example Explanation
Explanation 1:
 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:
 Window size is 1, so the output array is [1, 1, 1, 1].
*/
import java.util.*;;
public class DistinctNumbersInWindow {
    public static int[] dNums(int[] A, int B) {
        if(B > A.length)
        {
            int[] result = {};
            return result;
        }
        int[] result = new int[A.length-B+1];
        HashMap<Integer,Integer> hs = new HashMap<>();
        for(int i = 0;i<B;i++)
        {
            hs.put(A[i],hs.getOrDefault(A[i],0)+1);
        }
        result[0] = hs.size();
        int counter = 1;
        for(int i = B;i<A.length;i++)
        {
            hs.put(A[i-B],hs.get(A[i-B])-1);
            if(hs.get(A[i-B])==0)
                hs.remove(A[i-B]);
            hs.put(A[i],hs.getOrDefault(A[i],0)+1);
            result[counter] = hs.size();
            counter++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 3};
        int[] result = dNums(arr, 3);
        for(int a: result)
        {
            System.out.print(a+" ");
        }
        System.out.println();
    }
}
