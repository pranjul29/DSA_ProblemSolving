/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34945/assignment/problems/4385/?navref=cl_pb_nv_tb
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [5, 17, 100, 11]

Example Output
Output 1:
 33
Output 2:
 182

Example Explanation
Explanation 1:
 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15
 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
Explanation 2:
 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133
 So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
*/
import java.util.*;
public class ConnectRopes {
    public static int solve(int[] A) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(A.length);
        for(int i = 0;i<A.length;i++)
        {
            heap.add(A[i]);
        }
        System.out.println(heap);
        if(A.length == 1)
            return A[0];
        int sum = 0;
        while(heap.size()!=1)
        {
            int a = heap.poll();
            int b = heap.poll();
            sum += a+b;
            heap.add(a+b);
            System.out.println(heap);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {16, 7, 3, 5, 9, 8, 6, 15};
        System.out.println(solve(arr));
    }
}
