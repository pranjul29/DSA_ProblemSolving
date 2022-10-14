/* 
Source: https://www.scaler.com/academy/mentee-dashboard/class/34949/homework/problems/602/?navref=cl_pb_nv_tb
Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.

Problem Constraints
1 <= N <= 10^6
0 <= B <= 10^5
-10^5 <= A[i] <= 10^5

Example Input
Input 1:
 A = [1, 2, 3, 4] 
 B = 3
Input 2:
 A = [5, 1, 4, 2] 
 B = 5

Example Output
Output 1:
 4
Output 2:
 5

Example Explanation
Explanation 1:
 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
Explanation 2:
 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.
*/
import java.util.*;
class Pair
{
    int key;
    int value;
    public Pair(int key,int value)
    {
        this.key = key;
        this.value = value;
    }
}
public class MinimumLargestElement {
    public static int solve(int[] A, int B) {
        int maximum = Integer.MIN_VALUE;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>((p1,p2) -> {
            if(p1.key + p1.value < p2.key + p2.value)
                return -1;
            else if(p1.key + p1.value > p2.key + p2.value)
                return 1;
            else
                    return 0;
        });
        for(int i = 0;i<A.length;i++)
        {
            heap.add(new Pair(A[i],A[i]));
            maximum = Math.max(maximum,A[i]);
        }
        while(B>0)
        {
            B--;
            Pair p = heap.poll();
            p.key = p.key + p.value;
            maximum = Math.max(maximum,p.key);
            heap.add(p);
        }
        return maximum;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4 };
        int B = 3;
        System.out.println(solve(A,B));
    }
}
