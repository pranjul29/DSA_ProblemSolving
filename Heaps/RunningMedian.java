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
