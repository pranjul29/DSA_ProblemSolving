/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34949/assignment/problems/4369?navref=cl_tt_lst_nm
Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
Find and return the array C.
NOTE:
If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9

Example Input
Input 1:
 A = [1, 2, 5, 4, 3]
Input 2:
 A = [5, 17, 100, 11]

Example Output
Output 1:
 [1, 1, 2, 2, 3]
Output 2:
 [5, 5, 17, 11]

Example Explanation
Explanation 1:
 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3
Explanation 2:
 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11 
*/
import java.util.*;
public class RunningMedian {
    public static int[] solve(int[] A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        maxHeap.add(A[0]);
        int[] median = new int[A.length];
        median[0] = A[0];
        for(int i = 1;i<A.length;i++)
        {
            if(A[i] <= maxHeap.peek())
            {
                maxHeap.add(A[i]);
                if(maxHeap.size()-minHeap.size() > 1)
                {
                    minHeap.add(maxHeap.poll());
                }
            }
            else
            {
                minHeap.add(A[i]);
                if(minHeap.size() > maxHeap.size())
                {
                    maxHeap.add(minHeap.poll());
                }
            }
            median[i] = maxHeap.peek();
        }
        return median;
    }
    public static void main(String[] args) {
        int[] A = {5,17,100,11};
        System.out.println(solve(A));
    }    
}
