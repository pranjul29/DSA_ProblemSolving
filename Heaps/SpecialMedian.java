/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34949/homework/problems/446/?navref=cl_pb_nv_tb
You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.
Return 1 if the array is special else return 0.
NOTE:
For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]

Problem Constraints
1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.

Example Input
Input 1:
 A = [4, 6, 8, 4]
Input 2:
 A = [2, 7, 3, 1]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explantion 1:
 Here, 6 is equal to the median of [8, 4].
Explanation 2:
 No element satisfies any condition.
*/
import java.util.*;
public class SpecialMedian {
    public static int solve(int[] A) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<Long>(Collections.reverseOrder());
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        maxHeap.add((long)A[0]);
        for(int i = 1;i<A.length-1;i++)
        {
            if(maxHeap.peek() > (long)A[i])
            {
                maxHeap.add((long)A[i]);
                if(maxHeap.size()-minHeap.size()>1)
                    minHeap.add(maxHeap.poll());
            }
            else
            {
                minHeap.add((long)A[i]);
                if(minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
            }
            double median = 0;
            if((minHeap.size()+maxHeap.size())%2 == 0)
            {
                median = ((double)minHeap.peek() + (double)maxHeap.peek())/2;
            }
            else
            {
                median = maxHeap.peek();
            }
            if(median == (double)A[i+1])
                return 1;
        }
        maxHeap.clear();
        minHeap.clear();
        maxHeap.add((long)A[A.length-1]);
        for(int i = A.length-2;i>0;i--)
        {
            if(maxHeap.peek() > (long)A[i])
            {
                maxHeap.add((long)A[i]);
                if(maxHeap.size()-minHeap.size()>1)
                    minHeap.add(maxHeap.poll());
            }
            else
            {
                minHeap.add((long)A[i]);
                if(minHeap.size() > maxHeap.size())
                    maxHeap.add(minHeap.poll());
            }
            double median = 0;
            if((minHeap.size()+maxHeap.size())%2 == 0)
            {
                median = ((double)minHeap.peek() + (double)maxHeap.peek())/2;
            }
            else
            {
                median = (double)maxHeap.peek();
            }
            if(median == (double)A[i-1])
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] A = {4,6,8,4};
        System.out.println(solve(A));
    }
}
