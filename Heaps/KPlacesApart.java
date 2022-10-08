/*
Source: https://www.scaler.com/academy/mentee-dashboard/class/34949/assignment/problems/9264/?navref=cl_pb_nv_tb
Source: 
N people having different priorities are standing in a queue.
The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
Your task is to sort the queue in the increasing order of priorities.

NOTE:
No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).

Problem Constraints
1 <= N <= 100000
0 <= B <= N

Example Input
Input 1:
 A = [1, 40, 2, 3]
 B = 2
Input 2:
 A = [2, 1, 17, 10, 21, 95]
 B = 1

Example Output
Output 1:
 [1, 2, 3, 40]
Output 2:
 [1, 2, 10, 17, 21, 95]

Example Explanation
Explanation 1:
 Given array A = [1, 40, 2, 3]
 After sorting, A = [1, 2, 3, 40].
 We can see that difference between initial position of elements amd the final position <= 2.
Explanation 2:
 After sorting, the array becomes [1, 2, 10, 17, 21, 95].
*/
import java.util.*;
public class KPlacesApart {
    public static int[] solve(int[] A, int B) {
        // PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        if(A.length == B)
        {
            for(int i = 0;i<B;i++)
            {
                heap.add(A[i]);
            }
            int counter = 0;
            while(!heap.isEmpty())
            {
                A[counter] = heap.poll();
                counter++;
            }
            return A;
        }
        for(int i = 0;i<=B;i++)
        {
            heap.add(A[i]);
        }
        for(int i = B+1;i<A.length;i++)
        {
            A[i-B-1] = heap.poll();
            heap.add(A[i]);
        }
        int last = A.length - B - 1;
        while(!heap.isEmpty())
        {
            A[last] = heap.poll();
            last++;
        }
        return A;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 17, 10, 21, 95};
        int B = 1;
        System.out.println(solve(arr, B));
    }    
}
